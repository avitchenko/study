package tech.inni.study;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class WebinarTest {

    private static final Random random = new Random();

    private void check(boolean success) {
        if (success) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    // 4 метода

    @Test
    void testIsEven() {
        int n = random.nextInt(100) + 1;
        boolean actual = HomeWork.isEven(n);
        boolean expected = (n % 2 == 0);
        System.out.println("isEven(" + n + ") = " + actual + ", expected = " + expected);
        check(actual == expected);
    }

    @Test
    void testCheckAccess() {
        int age = random.nextInt(100);
        String actual = HomeWork.checkAccess(age);
        String expected = (age > 18) ? "Allowed" : "Denied";
        System.out.println("checkAccess(" + age + ") = " + actual + ", expected = " + expected);
        check(actual.equals(expected));
    }

    @Test
    void testIsPositive() {
        int n = random.nextInt(201) - 100; // -100..100
        boolean actual = HomeWork.isPositive(n);
        boolean expected = (n >= 0);
        System.out.println("isPositive(" + n + ") = " + actual + ", expected = " + expected);
        check(actual == expected);
    }

    @Test
    void testSumToN() {
        int n = random.nextInt(100);
        int actual = HomeWork.sumToN(n);
        int expected = 0;
        for (int i = 1; i <= n; i++) expected += i;
        System.out.println("sumToN(" + n + ") = " + actual + ", expected = " + expected);
        check(actual == expected);
    }

    // @RepeatedTest — 4 метода

    @RepeatedTest(5)
    void testGetGrade() {
        int score = random.nextInt(101);
        String actual = HomeWork.getGrade(score);
        String expected;
        if (score <= 20) expected = "E";
        else if (score <= 40) expected = "D";
        else if (score <= 60) expected = "C";
        else if (score <= 80) expected = "B";
        else expected = "A";
        System.out.println("getGrade(" + score + ") = " + actual + ", expected = " + expected);
        check(actual.equals(expected));
    }

    @RepeatedTest(5)
    void testBlastOff() {
        int start = random.nextInt(10) + 1; // 1..10
        String actual = HomeWork.blastOff(start);
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) sb.append(i).append(" ");
        sb.append("Поехали!");
        String expected = sb.toString();
        System.out.println("blastOff(" + start + ") = " + actual);
        check(actual.equals(expected));
    }

    @RepeatedTest(5)
    void testFindMax() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) arr[i] = random.nextInt(200) - 100;
        int actual = HomeWork.findMax(arr);
        int expected = arr[0];
        for (int x : arr) if (x > expected) expected = x;
        System.out.println("findMax(" + Arrays.toString(arr) + ") = " + actual + ", expected = " + expected);
        check(actual == expected);
    }

    @RepeatedTest(5)
    void testCalcAverage() {
        int size = random.nextInt(10) + 1;
        List<Integer> list = Stream.generate(() -> random.nextInt(100)).limit(size).toList();
        double actual = HomeWork.calcAverage(list);
        double expected = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("calcAverage(" + list + ") = " + actual + ", expected = " + expected);
        check(Math.abs(actual - expected) < 0.0001);
    }

    // @ParameterizedTest — 4 метода

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 9 })
    void testGetEvenInRange(int end) {
        String actual = HomeWork.getEvenInRange(1, end);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= end; i++) {
            if (i % 2 == 0) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(i);
            }
        }
        String expected = sb.toString();
        System.out.println("getEvenInRange(1, " + end + ") = \"" + actual + "\", expected = \"" + expected + "\"");
        check(actual.equals(expected));
    }

    @ParameterizedTest
    @CsvSource({
            "Hello,Bug,World,true",
            "hello,world,cat,false",
            "BUG,BUG,BUG,true"
    })
    void testHasBug(String s1, String s2, String s3, boolean expected) {
        String[] messages = { s1, s2, s3 };
        boolean actual = HomeWork.hasBug(messages);
        System.out.println("hasBug(" + Arrays.toString(messages) + ") = " + actual + ", expected = " + expected);
        check(actual == expected);
    }

    @ParameterizedTest
    @MethodSource("randomStringArrays")
    void testReverse(String[] arr) {
        String[] actual = HomeWork.reverse(arr);
        String[] expected = new String[arr.length];
        for (int i = 0; i < arr.length; i++) expected[i] = arr[arr.length - 1 - i];
        System.out.println("reverse(" + Arrays.toString(arr) + ") = " + Arrays.toString(actual));
        check(Arrays.equals(actual, expected));
    }

    @ParameterizedTest
    @MethodSource("listWithNames")
    void testRemoveSpecificName(List<String> list) {
        List<String> actual = HomeWork.removeSpecificName(list, "Bug");
        List<String> expected = list.stream().filter(x -> !x.equals("Bug")).toList();
        System.out.println("removeSpecificName(" + list + ") = " + actual);
        check(actual.equals(expected));
    }

    static Stream<Arguments> randomStringArrays() {
        return Stream.generate(() -> {
            int size = random.nextInt(5) + 1;
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = "item" + random.nextInt(10);
            }
            return Arguments.of((Object) arr);
        }).limit(5);
    }

    static Stream<List<String>> listWithNames() {
        return Stream.of(
                List.of("Ivan", "Bug", "Petr"),
                List.of("Bug", "Bug"),
                List.of("Anna", "Petr")
        );
    }
}