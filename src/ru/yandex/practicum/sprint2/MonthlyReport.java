package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {

    private static final int MONTH_AMOUNT = 12;
    List<MonthlyRecord> recordList;

    public List<MonthlyReport> getAllMonthlyReports() {
        List<MonthlyReport> monthlyReports = new ArrayList<>();

        for (int i = 1; i <= MONTH_AMOUNT; i++) {
            String monthlyReportRaw = "";
            if (i < 10) {
                monthlyReportRaw = Utils.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            } else {
                monthlyReportRaw = Utils.readFileContentsOrNull("resources/m.2021" + i + ".csv");
            }
            if (monthlyReportRaw != null) {
                MonthlyReport monthlyReport = createMonthlyReport(monthlyReportRaw);
                monthlyReports.add(monthlyReport);
            }
        }
        return monthlyReports;
    }

    public static String getMonthInfo() {
        String result = "";


    }


    private MonthlyReport createMonthlyReport(String monthlyReportRaw) {
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
        }

        return new MonthlyReport(recordList);

    }


}
