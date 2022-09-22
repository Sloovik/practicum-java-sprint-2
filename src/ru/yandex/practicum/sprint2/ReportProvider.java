package ru.yandex.practicum.sprint2;

import java.util.List;

public class ReportProvider {

    private List<MonthlyReport> monthlyReports;
    private YearlyReport yearlyReport;



    public void getAllMonthlyReports() {
        monthlyReports = MonthlyReport.getAllMonthlyReports();
        System.out.println(".");
//        System.out.println("��� �������� ������ ������� ���������.");
        System.out.println(monthlyReports.size());
    }

    public void getYearlyReport() {
        yearlyReport = YearlyReport.getYearlyReport();
        System.out.println(".");
        //System.out.println("������� ����� ������� ��������.");
        System.out.println(yearlyReport.recordList.size());
    }

    public void getMonthInfo() {
        if (monthlyReports == null) {
            System.out.println("Сначала заполните данные");
        } else {
            for (int i = 0; i < monthlyReports.size(); i++) {
                MonthlyReport report = monthlyReports.get(i);

                String monthName = Utils.getMonthName(i);
                String mostProfitable = report.getMostProfitableItem();
                String mostExpense = report.getMostExpense();
                System.out.println("Месяц: " + monthName + ".\n Самый выгодный товар: " +
                        mostProfitable + ".\n Самая большая трата: " + mostExpense);
            }
        }
    }
}
