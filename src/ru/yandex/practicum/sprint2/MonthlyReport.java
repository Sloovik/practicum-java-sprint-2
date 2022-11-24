/**
 * Класс с реализацией основной логики для работы с месячными отчетами.
 */

package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    private static final int MONTH_AMOUNT = 3;


    public HashMap<Integer, ArrayList<MonthlyReportLine>> monthlyReportsMap = new HashMap<>();

    public void getAllMonthlyReports() {


        for (int i = 1; i <= MONTH_AMOUNT; i++) {

            String monthlyReportRaw = Utils.readFileContentsOrNull("resources/m.20210" + i + ".csv");

            if (monthlyReportRaw != null) {
                ArrayList<MonthlyReportLine> importMonth = createMonthlyReport(monthlyReportRaw);
                monthlyReportsMap.put(i, importMonth);
                System.out.println("Месячный отчёт №" + i + " успешно загружен!");

            } else {
                System.out.println("Ошибка. Возможно, неверно указан путь, либо необходимые файлы отсутствуют.");
            }
        }

    }

    public void printReportsSummary() {
        if (monthlyReportsMap.isEmpty()) {
            System.out.println("Загрузите отчёты.");
        } else {
            for (Integer month : monthlyReportsMap.keySet()) {
                int monthMaxIncome = 0;
                int monthMaxExpense = 0;
                String monthMaxIncomeName = "";
                String monthMaxExpenseName = "";
                for (MonthlyReportLine reportLineToCompare : monthlyReportsMap.get(month)) {
                    if (!reportLineToCompare.isExpense) {
                        int comparingLineSum = reportLineToCompare.quantity * reportLineToCompare.sumOfOne;
                        if (comparingLineSum > monthMaxIncome) {
                            monthMaxIncome = comparingLineSum;
                            monthMaxIncomeName = reportLineToCompare.itemName;
                        }
                    } else {
                        int comparingLineSumExp = reportLineToCompare.quantity * reportLineToCompare.sumOfOne;
                        if (comparingLineSumExp > monthMaxExpense) {
                            monthMaxExpense = comparingLineSumExp;
                            monthMaxExpenseName = reportLineToCompare.itemName;
                        }
                    }
                }
                System.out.println(Month.getMonthName(month) + ": " + "Самый прибыльный товар: "
                        + monthMaxIncomeName + ", с доходом " + monthMaxIncome + "\n" + "Самая большая трата: "
                        + monthMaxExpenseName + " с расходом " + monthMaxExpense);
            }
        }
    }


    private ArrayList<MonthlyReportLine> createMonthlyReport(String monthlyReportRaw) {
        String[] lines = monthlyReportRaw.split("\n");

        ArrayList<MonthlyReportLine> monthReportArrayList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            MonthlyReportLine readLineFromFile = new MonthlyReportLine();
            readLineFromFile.itemName = lineContents[0];
            readLineFromFile.isExpense = Boolean.parseBoolean(lineContents[1]);
            readLineFromFile.quantity = Integer.parseInt(lineContents[2]);
            readLineFromFile.sumOfOne = Integer.parseInt(lineContents[3]);

            monthReportArrayList.add(readLineFromFile);
        }
        return monthReportArrayList;


    }

    public int getMonthlyTotalIncome(int month) {
        int totalIncome = 0;
        for (MonthlyReportLine monthlyRecord : monthlyReportsMap.get(month)) {
            if (!monthlyRecord.isExpense) {
                totalIncome += monthlyRecord.quantity * monthlyRecord.sumOfOne;
            }
        }
        return totalIncome;
    }

    public int getMonthlyTotalOutcome(int month) {
        int totalOutcome = 0;
        for (MonthlyReportLine monthlyRecord : monthlyReportsMap.get(month)) {
            if (monthlyRecord.isExpense) {
                totalOutcome += monthlyRecord.quantity * monthlyRecord.sumOfOne;
            }
        }
        return totalOutcome;
    }

}
