package ru.yandex.practicum.sprint2;

public class MonthlyReportLine {
    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;


    @Override
    public String toString() {
        return "MonthlyRecord{" +
                "itemName='" + itemName + '\'' +
                ", isExpense=" + isExpense +
                ", quantity=" + quantity +
                ", sumOfOne=" + sumOfOne +
                '}';
    }
}
