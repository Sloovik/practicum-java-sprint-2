package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {

    private static final int MONTH_AMOUNT = 3;
    List<MonthlyRecord> recordList;

    public MonthlyReport(List<MonthlyRecord> recordList) {
        this.recordList = recordList;
    }

    public static List<MonthlyReport> getAllMonthlyReports() {
        List<MonthlyReport> monthlyReports = new ArrayList<>();

        for (int i = 1; i <= MONTH_AMOUNT; i++) {

            String monthlyReportRaw = Utils.readFileContentsOrNull("resources/m.20210" + i + ".csv");

            if (monthlyReportRaw != null) {
                MonthlyReport monthlyReport = createMonthlyReport(monthlyReportRaw);
                monthlyReports.add(monthlyReport);
            }
        }
        return monthlyReports;
    }




    private static MonthlyReport createMonthlyReport(String monthlyReportRaw) {
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

    public String getMostProfitableItem() {

        int mostProfit = 0;
        MonthlyRecord maxProfitRecord = null;

        if (recordList != null) {
            for (MonthlyRecord record : recordList) {
                if (!record.isExpense) {
                    int currentProfit = record.quantity * record.sumOfOne;

                    if (currentProfit > mostProfit) {
                        mostProfit = currentProfit;
                        maxProfitRecord = record;
                    }

                }
            }
            return "Максимально прибыльный товар: " + maxProfitRecord.itemName
                    + " с прибылью " + mostProfit;
        } else {
            return "";
        }
    }

    public String getMostExpense() {

        int mostExpense = 0;
        MonthlyRecord mostExpenseRecord = null;

        if (recordList != null) {
            for (MonthlyRecord record : recordList) {
                if (record.isExpense) {
                    int currentExpense = record.quantity * record.sumOfOne;

                    if (currentExpense > mostExpense) {
                        mostExpense = currentExpense;
                        mostExpenseRecord = record;
                    }
                }
            }
            return "Самая большая трата: " + mostExpenseRecord.itemName
                    + ", потрачено: " + mostExpense + " руб.";
        } else {
            return "";
        }
    }


}
