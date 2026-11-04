package tech.inni.study.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@Tag("Api")
@DisplayName("Эндпоинт PATCH /goods/{id}")
public class GoodsPatchApiTest {

    @Test
    @DisplayName("200: Успешное обновление товара")
    void testPatchGoodSuccess() {
        String oldName = "OldName" + System.currentTimeMillis();
        String newName = "NewName" + System.currentTimeMillis();

        int id = given()
                .spec(RestApiBuilder.getBuilder())
                .body("{\"name\": \"" + oldName + "\"}")
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200)
                .extract().path("data.id");

        given()
                .spec(RestApiBuilder.getBuilder())
                .pathParam("id", id)
                .body("{\"name\": \"" + newName + "\"}")
                .when()
                .patch("/goods/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Ошибка: Обновление несуществующего товара")
    void testPatchGoodNotFound() {
        given()
                .spec(RestApiBuilder.getBuilder())
                .pathParam("id", 9999999)
                .body("{\"name\": \"Some Name\"}")
                .when()
                .patch("/goods/{id}")
                .then()
                .statusCode(anyOf(is(400), is(404), is(500)));
    }
}