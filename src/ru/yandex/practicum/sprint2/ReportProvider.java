package ru.yandex.practicum.sprint2;

public class ReportProvider {

    public void getAllMonthlyReports() {
        MonthlyReport.getAllMonthlyReports();
        System.out.println("Все месячные отчеты успешно загружены");
    }

    public void getYearlyReport() {
        YearlyReport.getYearlyReport();
    }

}
