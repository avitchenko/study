package tech.inni.study.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@Tag("Api")
@DisplayName("Эндпоинт GET /goods/{id}")
public class GoodsGetByIdApiTest {

    @Test
    @DisplayName("200: Получение товара по ID")
    void testGetGoodByIdSuccess() {
        String name = "ProductGet" + System.currentTimeMillis();

        int id = given()
                .spec(RestApiBuilder.getBuilder())
                .body("{\"name\": \"" + name + "\"}")
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200)
                .extract().path("data.id");

        given()
                .spec(RestApiBuilder.getBuilder())
                .pathParam("id", id)
                .when()
                .get("/goods/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Ошибка: Товар с таким ID не найден")
    void testGetGoodByIdNotFound() {
        given()
                .spec(RestApiBuilder.getBuilder())
                .pathParam("id", 9999999)
                .when()
                .get("/goods/{id}")
                .then()
                .statusCode(anyOf(is(400), is(404), is(500)));
    }
}