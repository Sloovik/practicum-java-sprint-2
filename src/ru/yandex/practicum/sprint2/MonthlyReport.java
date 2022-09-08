package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.List;


public class MonthlyReport {
    static List<MonthlyRecord> recordList;



    public MonthlyReport(List<MonthlyRecord> recordList) {
        this.recordList = recordList;
    }



    public static void addMonthlyReport() {
        List<MonthlyReport> monthlyReports = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String monthlyReportRaw = Utils.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            MonthlyReport monthlyReport = createReport(monthlyReportRaw);
            monthlyReports.add(monthlyReport);
        }
    }



    private static MonthlyReport createReport(String monthlyReportRaw) {
        String[] lines = monthlyReportRaw.split("\n");

        List<MonthlyRecord> recordList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            MonthlyRecord record = new MonthlyRecord(
                    lineContents[0],
                    Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]),
                    Integer.parseInt(lineContents[3])
            );
            recordList.add(record);
            System.out.println(record);
        }

        return new MonthlyReport(recordList);

    }


}
