package tech.inni.study.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@Tag("Api")
@DisplayName("Эндпоинт DELETE /goods/{id}")
public class GoodsDeleteApiTest {

    @Test
    @DisplayName("200: Успешное удаление товара")
    void testDeleteGoodSuccess() {
        String name = "DeleteTest" + System.currentTimeMillis();

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
                .delete("/goods/{id}")
                .then()
                .statusCode(anyOf(is(200), is(204)));
    }

    @Test
    @DisplayName("Ошибка: Удаление несуществующего товара")
    void testDeleteGoodNotFound() {
        given()
                .spec(RestApiBuilder.getBuilder())
                .pathParam("id", 9999999)
                .when()
                .delete("/goods/{id}")
                .then()
                .statusCode(anyOf(is(400), is(404), is(500)));
    }
}