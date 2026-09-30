package tech.inni.study;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    // Задача 1: isEven
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Задача 2: checkAccess
    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }

    // Задача 3: isPositive (через тернарник — по заданию!)
    public static boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    // Задача 4: getGrade
    public static String getGrade(int score) {
        if (score < 0 || score > 100) {
            return "Error";
        }
        if (score <= 20) {
            return "E";
        } else if (score <= 40) {
            return "D";
        } else if (score <= 60) {
            return "C";
        } else if (score <= 80) {
            return "B";
        } else {
            return "A";
        }
    }

    // Задача 5: blastOff
    public static String blastOff(int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("Поехали!");
        return sb.toString();
    }

    // Задача 6: sumToN
    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Задача 7: hasBug
    public static boolean hasBug(String[] messages) {
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].equalsIgnoreCase("Bug")) {
                return true;
            }
        }
        return false;
    }

    // Задача 8: getEvenInRange
    public static String getEvenInRange(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(i);
            }
        }
        return sb.toString();
    }

    // Задача 9: findMax
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Задача 10: reverse
    public static String[] reverse(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    // Задача 11: calcAverage
    public static double calcAverage(List<Integer> list) {
        if (list.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return (double) sum / list.size();
    }

    // Задача 12: removeSpecificName
    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            if (!current.equals(nameToRemove)) {
                result.add(current);
            }
        }
        return result;
    }
}