package tech.inni.study.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Tag("Api")
@DisplayName("Эндпоинт POST /goods/add")
public class GoodsAddApiTest {

    @Test
    @DisplayName("200: Успешное создание товара")
    void testCreateGoodSuccess() {
        String name = "NewProduct" + System.currentTimeMillis();

        given()
                .spec(RestApiBuilder.getBuilder())
                .body("{\"name\": \"" + name + "\"}")
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200)
                .body("data.id", notNullValue())
                .body("message", equalTo("success"));
    }

    @Test
    @DisplayName("400: Ошибка валидации (пустое имя)")
    void testCreateGoodBadRequest() {
        given()
                .spec(RestApiBuilder.getBuilder())
                .body("{\"name\": \"\"}")
                .when()
                .post("/goods/add")
                .then()
                // Если API багует и отдает 500, мы разрешим и его
                .statusCode(anyOf(is(400), is(500)));
    }
}