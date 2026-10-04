package tech.inni.study;

import java.util.ArrayList;
import java.util.List;

public class AssertionsHomeWork {

    // Возвращает boolean
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Возвращает boolean
    public static boolean isPositive(int n) {
        return n >= 0;
    }

    // Возвращает список - фильтрует положительные
    public static List<Integer> filterPositive(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int x : list) {
            if (x > 0) result.add(x);
        }
        return result;
    }

    // Возвращает список - удаляет имя
    public static List<String> removeName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (!s.equals(nameToRemove)) result.add(s);
        }
        return result;
    }

}