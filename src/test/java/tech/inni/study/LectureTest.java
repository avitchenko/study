package tech.inni.study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

class LectureTest {

    private static final Random random = new Random();

    @BeforeEach
    void beforeEach() {
        System.out.println("========================Test method start");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test method end");
        System.out.println("========================");
    }

    // isEven: один раз со случайным числом от 1 до 100
    @Test
    void testIsEven() {
        int n = random.nextInt(100) + 1; // 1..100
        boolean result = HomeWork.isEven(n);
        System.out.println("isEven(" + n + ") = " + result);
    }

    //  checkAccess: 20 раз со случайными числами от 0 до 99
    @RepeatedTest(20)
    void testCheckAccess() {
        int age = random.nextInt(100); // 0..99
        String result = HomeWork.checkAccess(age);
        System.out.println("checkAccess(" + age + ") = " + result);
    }

    // getGrade: параметризованный тест с массивом случайных 0..100
    @ParameterizedTest
    @MethodSource("randomScores")
    void testGetGrade(int score) {
        String result = HomeWork.getGrade(score);
        System.out.println("getGrade(" + score + ") = " + result);
    }

    static Stream<Integer> randomScores() {
        return Stream.generate(() -> random.nextInt(101)) // 0..100
                .limit(10);
    }
}