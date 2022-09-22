package ru.yandex.practicum.sprint2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportProvider provider = new ReportProvider();
        int command = -1;

        while (command!= 0 ) {
            printMenu();
            command = scanner.nextInt();

            switch (command) {
                case 1 -> provider.getAllMonthlyReports();
                case 2 -> provider.getYearlyReport();
                case 4 -> provider.getMonthInfo();
                case 0 -> System.out.println("До встречи!");
                default -> System.out.println("Введено некорректное значение.");
            }
        }


    }

    private static void printMenu() {

        System.out.println(
                """
                        Выберите необходимое действие:
                        1 - Считать все месячные отчёты
                        2 - Считать годовой отчёт
                        3 - Сверить отчёты
                        4 - Вывести информацию о всех месячных отчётах
                        5 - Вывести информацию о годовом отчёте
                        0 - Выход."""
        );
    }


}

