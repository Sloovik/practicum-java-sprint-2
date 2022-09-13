package ru.yandex.practicum.sprint2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {
    static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

  public static String getMonthName(int monthNumber) {
        return switch (monthNumber) {
            case 0 -> "Январь.";
            case 1 -> "Февраль.";
            case 2 -> "Март.";
            default -> "";
        };
    }

}
