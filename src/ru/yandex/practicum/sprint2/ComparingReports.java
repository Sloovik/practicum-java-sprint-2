/**
 * Класс для сопоставления данных в отчетах.
 */

package ru.yandex.practicum.sprint2;

public class ComparingReports {

    public static void compareReports(MonthlyReport monthlyReport, YearlyReport yearlyReport) {

        try {
            boolean isSuccessful = true;
            for (int i = 1; i < 4; i++) {
                if ((monthlyReport.getMonthlyTotalIncome(i) != yearlyReport.getMonthlyIncome(i)) ||
                        (monthlyReport.getMonthlyTotalOutcome(i) != yearlyReport.getMonthlyOutcome(i))) {
                    System.out.println(Month.getMonthName(i) + ": обнаружено несоответствие!");
                    isSuccessful = false;
                }
            }
            if (isSuccessful) {
                System.out.println("Отчеты сходятся!");
            }
        } catch (NullPointerException e) {
            System.out.println("Сначала нужно загрузить отчеты.");
        }
    }

}
