package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        int command = -1;

        while (command!= 0 ) {
            printMenu();
            command = scanner.nextInt();

            switch (command) {
                case 1 -> monthlyReport;
                case 0 -> System.out.println("До встречи!");
                default -> System.out.println("Введено некорректное значение.");
            }
        }


    }

    private static void printMenu() {
        System.out.println(
                """
                        Введите номер нужной операции:
                        1 - Считать все месячные отчёты
                        2 - Считать годовой отчёт
                        3 - Сверить отчёты
                        4 - Вывести информацию о всех месячных отчётах
                        5 - Вывести информацию о годовом отчёте
                        0 - Выход."""
        );
    }


}

