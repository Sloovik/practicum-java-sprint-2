package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.List;

public class YearlyReport {

    List<YearlyRecord> recordList;

    public YearlyReport(List<YearlyRecord> recordList) {
        this.recordList = recordList;
    }

    private static YearlyReport getYearlyReport() {
        String yearlyReportRaw = Utils.readFileContentsOrNull("resources/y.2021.csv");
        YearlyReport yearlyReport = null;
        if (yearlyReportRaw != null) {
            yearlyReport = createYearlyReport(yearlyReportRaw);
        }
        return yearlyReport;
    }

    private static YearlyReport createYearlyReport(String yearlyReportRaw) {
        String[] lines = yearlyReportRaw.split("\n");

        List<YearlyRecord> recordList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            YearlyRecord record = new YearlyRecord(
                    lineContents[0],
                    Integer.parseInt(lineContents[1]),
                    Boolean.parseBoolean(lineContents[2])
            );
            recordList.add(record);
        }

        return new YearlyReport(recordList);
    }

}

