/**
 * Вспомогательный класс для определения месяца.
 */

package ru.yandex.practicum.sprint2;

public class Month {

    private static final String[] months = {"Январь", "Февраль", "Март"};

    public static String getMonthName (int monthNumber) {
        return months[monthNumber-1];
    }
}
