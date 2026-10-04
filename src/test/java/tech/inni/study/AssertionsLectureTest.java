package tech.inni.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Assertions")
@DisplayName("ДЗ по ассертам: 4 теста с информативными ассертами")
class AssertionsLectureTest {

    //Тест 1: метод возвращает boolean, ассерт проходит
    @Test
    @DisplayName("isEven(4) должен вернуть true")
    void testIsEven_True() {
        int n = 4;
        boolean actual = AssertionsHomeWork.isEven(n);
        assertTrue(actual,
                "isEven(" + n + ") должен вернуть true, потому что " + n + " чётное");
    }

    //Тест 2: метод возвращает boolean, ассерт проходит через assertFalse
    @Test
    @DisplayName("isPositive(-5) должен вернуть false")
    void testIsPositive_False() {
        int n = -5;
        boolean actual = AssertionsHomeWork.isPositive(n);
        assertFalse(actual,
                "isPositive(" + n + ") должен вернуть false, потому что " + n + " < 0");
    }

    //Тест 3: метод возвращает список, проверяем поэлементно
    @Test
    @DisplayName("filterPositive([-1, 2, -3, 4]) должен вернуть [2, 4]")
    void testFilterPositive_ReturnsList() {
        List<Integer> input = List.of(-1, 2, -3, 4);
        List<Integer> expected = List.of(2, 4);
        List<Integer> actual = AssertionsHomeWork.filterPositive(input);

        assertEquals(expected, actual,
                "filterPositive должен оставить только положительные числа. " +
                        "Ожидалось: " + expected + ", получено: " + actual);
    }

    //Тест 4: метод возвращает список, ассерт ПАДАЕТ
    @Test
    @DisplayName("FAILED тест: removeName ожидает неверный результат")
    void testRemoveName_ShouldFailOnPurpose() {
        List<String> input = List.of("Ivan", "Bug", "Petr");
        // Внимание: намеренно неверное ожидание — должно быть ["Ivan", "Petr"]
        List<String> wrongExpected = List.of("Ivan", "Bug", "Petr");
        List<String> actual = AssertionsHomeWork.removeName(input, "Bug");

        assertEquals(wrongExpected, actual,
                "FAILED тест " + "Ожидалось: " + wrongExpected + ", но фактически: " + actual);
    }
}