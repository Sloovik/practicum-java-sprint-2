/**
 *  ласс с реализацией основной логики дл€ работы с годовым отчетом.
 */

package ru.yandex.practicum.sprint2;

import java.util.ArrayList;


public class YearlyReport {

    private ArrayList<YearlyReportLine> yearlyReport = new ArrayList<>();

    public void getYearlyReport() {
        String yearlyReportRaw = Utils.readFileContentsOrNull("resources/y.2021.csv");
        ArrayList<YearlyReportLine> importYear;
        importYear = createYearlyReport(yearlyReportRaw);
        if (importYear != null) {
            yearlyReport = importYear;
        } else {
            System.out.println("ќтчет за год не был загружен.");
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
            System.out.println(yearReportArrayList);
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
            System.out.println("—начала загрузите отчет.");
        } else {
            int monthlyProfit = 0;
            int averageIncome = 0;
            int averageOutcome = 0;
            System.out.println("–ассматриваемый год - 2021.");
            for (int i = 1; i < 4; i++) {
                monthlyProfit = getMonthlyIncome(i) - getMonthlyOutcome(i);
                averageIncome += getMonthlyIncome(i);
                averageOutcome += getMonthlyOutcome(i);
                System.out.println("ѕрибыль за мес€ц " + Month.getMonthName(i) + ": " + monthlyProfit);
            }
            System.out.println("—редний доход за все мес€цы в году: " + averageIncome / 3 + "\n"
                    + "—редний расход за все мес€цы в году" + averageOutcome / 3);

        }
    }


}


