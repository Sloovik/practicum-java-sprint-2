package ru.yandex.practicum.sprint2;

public class YearlyRecord {
    int month;
    int amount;
    boolean isExpense;

    public YearlyRecord(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
