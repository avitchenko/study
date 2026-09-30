import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

@Tag("Smoke")

public class EnvTest {

    private boolean isNotEven(int value) {
        return !(value % 2 == 0);
    }

    @Test
    @Tag("Smoke")
    void envTest1() {
        System.out.println("test circuit: " + System.getProperty("CIRCUIT"));
        System.out.println("test account : " + System.getenv("TEST_LOGIN"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 1000, 1001})
    void isNotEvenTest(int value) {
     System.out.println("Test with value = " + value);
     if (isNotEven(value) == true) {
         System.out.println("TRUE!");
     } else {
         System.out.println("FALSE!");
     }
    }

    @ParameterizedTest
    @CsvSource ({"0, false", "1, true", "2, true", "1000, false", "1001, true"})
    void isNotEvenSecondTest(int value, boolean expectedResult) {
        if (isNotEven(value) == expectedResult){
            System.out.println("PASSED!!");
        } else {
            System.out.println("FAILED!!");
        }
    }

    @ParameterizedTest
    @EnumSource(value = Role.class)
    void roleTest(Role role) {
        switch (role) {
            case Admin -> {
                System.out.println("Login as ADMIN");
            }
            case Tester -> {
                System.out.println("Login as TESTER");
            }
            case Observer -> {
                System.out.println("Can not run test as OBSERVER");
            }
        }
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void tenDivTest(int value) {
        System.out.println(value % 10);
    }


    static List<Integer> getTestData() {
        return List.of(25, 31, 44, 58);
    }


}
