import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    @Test
    // Задача 1: разработать метод с сигнатурой publiс static boolean isEven(int n).
    // Метод возвращает true, если число чётное, и false — если нечётное.

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    //Задача 2: разработать метод с сигнатурой public static String checkAccess(int age).
    // Метод возвращает Allowed, если число строго больше 18, и Denied — если меньше.

    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }

    // Задача 3: разработать метод с сигнатурой public static boolean isPositive(int n).
    // Метод должен возвращать true, если переданное число больше или равно нулю, и false, если переданное число меньше нуля.
    // Проверка внутри метода должна происходить с помощью тернарного оператора.

    public static boolean isPositive(int n) {
        return n >= 0;
    }

    // Задача 4: разработать метод с сигнатурой public static String getGrade(int score).
    // Метод возвращает строку, соответствующую строгому вхождению в границы:
    //
    //0–20: E;
    //21–40: D;
    //41–60: C;
    //61–80: B;
    //81–100: A.
    //Если переданное число не входит в границы — вернуть строку Error.

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

    // Задача 5: разработать метод с сигнатурой public static String blastOff(int start).
    // Метод принимает стартовое число (например, 5) и возвращает строку со всеми числами до 1 и словом «Поехали!» в конце (например, «5 4 3 2 1 Поехали!»).

    public static String blastOff(int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("Поехали!");
        return sb.toString();
    }

    // Задача 6: разработать метод с сигнатурой publiс static int sumToN(int n).
    // Метод возвращает сумму всех целых чисел от 1 до n.

    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    // Задача 7: разработать метод с сигнатурой publiс static boolean hasBug(String[] messages).
    // Метод принимает массив строк и возвращает true, если хотя бы одна строка в массиве равна Bug.
    // Сравнение можно выполнять без учёта регистра.

    public static boolean hasBug(String[] messages) {
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].equalsIgnoreCase("Bug")) {
                return true;
            }
        }
        return false;
    }

    // Задача 8: разработать метод с сигнатурой publiс static getEvenInRange(int start, int end).
    // Метод принимает границы диапазона и возвращает строку, состоящую только из чётных чисел внутри этого промежутка (включая границы), разделённых пробелом.
    // Перед первым и после последнего числа пробел не ставится. Например: (2, 5) -> “2 4”

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

    // Задача 9: разработать метод с сигнатурой publiс static public int findMax(int[] arr).
    // Метод находит и возвращает самое большое число в переданном массиве.

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Задача 10: разработать метод с сигнатурой publiс static String[] reverse(String[] arr).
    // Метод возвращает новый массив, в котором элементы исходного массива расположены в обратном порядке.
    // Например, {“One”, “Two”, “Zero”} -> {“Zero”, “Two”, “One}.

    public static String[] reverse(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    // Задача 11: разработать метод с сигнатурой publiс static calcAverage(List list).
    // Метод вычисляет и возвращает среднее арифметическое всех чисел в списке.

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

    // Задача 12: разработать метод с сигнатурой publiс static List removeSpecificName(List list, String nameToRemove).
    // Метод принимает список и имя, которое нужно исключить.
    // Возвращает новый список, не содержащий указанного имени.

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
