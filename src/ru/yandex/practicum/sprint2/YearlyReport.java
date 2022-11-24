/**
 * ����� � ����������� �������� ������ ��� ������ � ������� �������.
 */

package ru.yandex.practicum.sprint2;

import java.util.ArrayList;


public class YearlyReport {

    private ArrayList<YearlyReportLine> yearlyReport = new ArrayList<>();

    public void getYearlyReport() {
        String yearlyReportRaw = Utils.readFileContentsOrNull("resources/y.2021.csv");
        ArrayList<YearlyReportLine> importYear;

        if (yearlyReportRaw != null) {
            importYear = createYearlyReport(yearlyReportRaw);
            yearlyReport = importYear;
            System.out.println("������� ����� ������� ��������!");
        } else {
            System.out.println("������. ��������, ������� ������ ����, ���� ����������� ����� �����������.");
        }
    }

    private ArrayList<YearlyReportLine> createYearlyReport(String yearlyReportRaw) {
        String[] lines = yearlyReportRaw.split("\n");


        ArrayList<YearlyReportLine> yearReportArrayList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {

            String[] lineContents = lines[i].split(",");

            YearlyReportLine readLineFromFile = new YearlyReportLine();
            readLineFromFile.month = Integer.parseInt(lineContents[0]);
            readLineFromFile.amount = Integer.parseInt(lineContents[1]);
            readLineFromFile.isExpense = Boolean.parseBoolean(lineContents[2]);

            yearReportArrayList.add(readLineFromFile);
        }
        return yearReportArrayList;
    }

    public Integer getMonthlyIncome(int month) {
        for (YearlyReportLine monthRecord : yearlyReport) {
            if ((monthRecord.month == month) && !monthRecord.isExpense) {
                return monthRecord.amount;
            }
        }
        return null;
    }

    public Integer getMonthlyOutcome(int month) {
        for (YearlyReportLine monthRecord : yearlyReport) {
            if ((monthRecord.month == month) && monthRecord.isExpense) {
                return monthRecord.amount;
            }
        }
        return null;
    }

    public void printReport() {
        if (yearlyReport.isEmpty()) {
            System.out.println("������� ��������� �����.");
        } else {
            int monthlyProfit = 0;
            int averageIncome = 0;
            int averageOutcome = 0;
            System.out.println("��������������� ��� - 2021.");
            for (int i = 1; i < 4; i++) {
                monthlyProfit = getMonthlyIncome(i) - getMonthlyOutcome(i);
                averageIncome += getMonthlyIncome(i);
                averageOutcome += getMonthlyOutcome(i);
                System.out.println("������� �� ����� " + Month.getMonthName(i) + ": " + monthlyProfit);
            }
            System.out.println("������� ����� �� ��� ������ � ����: " + averageIncome / 3 + "\n"
                    + "������� ������ �� ��� ������ � ����" + averageOutcome / 3);

        }
    }


}


