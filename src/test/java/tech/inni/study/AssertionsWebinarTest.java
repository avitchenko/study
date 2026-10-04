package tech.inni.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Assertions")
@DisplayName("ДЗ по ассертам: тесты с информативными ассертами")
class AssertionsWebinarTest {

    private static final Random random = new Random();

    //@RepeatedTest(10) — 4 метода

    @RepeatedTest(value = 10, name = "Повтор {currentRepetition} из {totalRepetitions}")
    @DisplayName("isEven: 10 случайных проверок")
    void testIsEven() {
        int n = random.nextInt(100) + 1;
        boolean actual = HomeWork.isEven(n);
        boolean expected = (n % 2 == 0);
        assertEquals(expected, actual,
                "isEven(" + n + "): ожидалось " + expected + ", получено " + actual);
    }

    @RepeatedTest(10)
    @DisplayName("checkAccess: 10 случайных проверок")
    void testCheckAccess() {
        int age = random.nextInt(100);
        String actual = HomeWork.checkAccess(age);
        String expected = (age > 18) ? "Allowed" : "Denied";
        assertEquals(expected, actual,
                "checkAccess(" + age + "): ожидалось " + expected + ", получено " + actual);
    }

    @RepeatedTest(10)
    @DisplayName("isPositive: 10 случайных проверок")
    void testIsPositive() {
        int n = random.nextInt(201) - 100;
        boolean actual = HomeWork.isPositive(n);
        boolean expected = (n >= 0);
        assertEquals(expected, actual,
                "isPositive(" + n + "): ожидалось " + expected + ", получено " + actual);
    }

    @RepeatedTest(10)
    @DisplayName("sumToN: 10 случайных проверок")
    void testSumToN() {
        int n = random.nextInt(50);
        int actual = HomeWork.sumToN(n);
        int expected = 0;
        for (int i = 1; i <= n; i++) expected += i;
        assertEquals(expected, actual,
                "sumToN(" + n + "): ожидалось " + expected + ", получено " + actual);
    }

    //@ParameterizedTest — 4 метода

    @ParameterizedTest
    @ValueSource(ints = { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 })
    @DisplayName("getGrade: 10 параметров из ValueSource")
    void testGetGrade(int score) {
        String actual = HomeWork.getGrade(score);
        String expected;
        if (score <= 20) expected = "E";
        else if (score <= 40) expected = "D";
        else if (score <= 60) expected = "C";
        else if (score <= 80) expected = "B";
        else expected = "A";
        assertEquals(expected, actual,
                "getGrade(" + score + "): ожидалось " + expected + ", получено " + actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Hello,Bug,World,true",
            "hello,world,cat,false",
            "BUG,BUG,BUG,true",
            "bug,cat,dog,true",
            "one,two,three,false",
            "Bug,,,true",
            "a,b,c,false",
            "x,y,BUG,true",
            "no,bug,here,true",
            "clean,code,here,false"
    })
    @DisplayName("hasBug: 10 наборов из CSV")
    void testHasBug(String s1, String s2, String s3, boolean expected) {
        String[] messages = { s1, s2, s3 };
        boolean actual = HomeWork.hasBug(messages);
        assertEquals(expected, actual,
                "hasBug(" + Arrays.toString(messages) + "): ожидалось " + expected + ", получено " + actual);
    }

    @ParameterizedTest
    @MethodSource("randomStringArrays")
    @DisplayName("reverse: 10 случайных массивов")
    void testReverse(String[] arr) {
        String[] actual = HomeWork.reverse(arr);
        String[] expected = new String[arr.length];
        for (int i = 0; i < arr.length; i++) expected[i] = arr[arr.length - 1 - i];
        assertArrayEquals(expected, actual,
                "reverse(" + Arrays.toString(arr) + "): ожидалось " + Arrays.toString(expected)
                        + ", получено " + Arrays.toString(actual));
    }

    @ParameterizedTest
    @MethodSource("listsWithNames")
    @DisplayName("removeSpecificName: 10 списков")
    void testRemoveSpecificName(List<String> list) {
        List<String> actual = HomeWork.removeSpecificName(list, "Bug");
        List<String> expected = new ArrayList<>();
        for (String s : list) if (!s.equals("Bug")) expected.add(s);
        assertEquals(expected, actual,
                "removeSpecificName(" + list + "): ожидалось " + expected + ", получено " + actual);
    }

    static Stream<Arguments> randomStringArrays() {
        return Stream.generate(() -> {
            int size = random.nextInt(5) + 1;
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) arr[i] = "item" + random.nextInt(10);
            return Arguments.of((Object) arr);
        }).limit(10);
    }

    static Stream<List<String>> listsWithNames() {
        return Stream.of(
                List.of("Ivan", "Bug", "Petr"),
                List.of("Bug", "Bug"),
                List.of("Anna", "Petr"),
                List.of("Bug"),
                List.of(),
                List.of("A", "B", "C"),
                List.of("Bug", "Bug", "Bug"),
                List.of("X", "Bug", "Y", "Bug"),
                List.of("only"),
                List.of("Bug", "ok")
        );
    }
}