package ru.yandex.practicum.sprint2;

public class YearlyReportLine {

    int month;
    int amount;
    boolean isExpense;

    @Override
    public String toString() {
        return "YearlyReportLine{" +
                "month='" + month + '\'' +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }
}
