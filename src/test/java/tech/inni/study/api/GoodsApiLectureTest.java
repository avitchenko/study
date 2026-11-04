package tech.inni.study.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("Api")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Лекция: 4 способа проверки GET /goods/list")
public class GoodsApiLectureTest {

    // 1. given/when/then
    @Test
    @Order(1)
    @DisplayName("1. given/when/then — проверка кода и структуры ответа")
    void testGivenWhenThen() {
        given()
                .spec(RestApiBuilder.getBuilder())
                .when()
                .get("/goods/list")
                .then()
                .statusCode(200)
                // Проверяем, что в ответе есть массив goods (он может быть пустым или с данными)
                .body("goods", notNullValue());
    }

    // 2. RequestSpecification
    @Test
    @Order(2)
    @DisplayName("2. RequestSpecification — проверка кода и структуры ответа")
    void testSpec() {
        given()
                .spec(RestApiBuilder.getBuilder())
                .when()
                .get("/goods/list")
                .then()
                .statusCode(200)
                .body("goods", notNullValue());
    }

    // 3. Создание + встроенные проверки REST Assured
    @Test
    @Order(3)
    @DisplayName("3. Создание и проверка встроенными проверками REST Assured")
    void testCreateRestAssured() {
        String uniqueName = "TestRest" + System.currentTimeMillis();

        // Создаем товар
        given()
                .spec(RestApiBuilder.getBuilder())
                .body("{\"name\": \"" + uniqueName + "\"}")
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200);

        // Проверяем, что он в списке
        given()
                .spec(RestApiBuilder.getBuilder())
                .when()
                .get("/goods/list")
                .then()
                .statusCode(200)
                .body("goods.name", hasItem(uniqueName));
    }

    // 4. Создание + проверка через AssertJ
    @Test
    @Order(4)
    @DisplayName("4. Создание и проверка через AssertJ")
    void testCreateAssertJ() {
        String uniqueName = "TestAssert" + System.currentTimeMillis();

        // Создаем товар
        given()
                .spec(RestApiBuilder.getBuilder())
                .body("{\"name\": \"" + uniqueName + "\"}")
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200);

        // Получаем список и проверяем через AssertJ
        Response response = given()
                .spec(RestApiBuilder.getBuilder())
                .when()
                .get("/goods/list")
                .then()
                .statusCode(200)
                .extract().response();

        List<String> names = response.jsonPath().getList("goods.name");

        assertThat(names)
                .as("В списке должен быть созданный товар " + uniqueName)
                .contains(uniqueName);
    }
}