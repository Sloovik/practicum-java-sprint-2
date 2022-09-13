package ru.yandex.practicum.sprint2;

import java.util.List;

public class ReportProvider {

    private List<MonthlyReport> monthlyReports;
    private YearlyReport yearlyReport;



    public void getAllMonthlyReports() {
        monthlyReports = MonthlyReport.getAllMonthlyReports();
        System.out.println("biba.");
//        System.out.println("��� �������� ������ ������� ���������.");
        System.out.println(monthlyReports.size());
    }

    public void getYearlyReport() {
        yearlyReport = YearlyReport.getYearlyReport();
        System.out.println("boba.");
        //System.out.println("������� ����� ������� ��������.");
        System.out.println(yearlyReport.recordList.size());
    }

    public void getMonthInfo() {
        if (monthlyReports == null) {
            System.out.println("������� ��������� ������");
        } else {
            for (int i = 1; i <= monthlyReports.size(); i++) {
                MonthlyReport report = monthlyReports.get(i);

                String monthName = Utils.getMonthName(i);
                String mostProfitable = report.getMostProfitableItem();
                String mostExpense = report.getMostExpense();
                System.out.println("�����: " + monthName + ".\n ����� ������� �����: " +
                        mostProfitable + ".\n ����� ������� �����: " + mostExpense);
            }
        }
    }
}
