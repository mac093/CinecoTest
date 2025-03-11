package APITests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class APITest {

    @Test
    public void testGETRickAndMortyAPI() {
        given()
        .baseUri("https://rickandmortyapi.com/api")
            .when()
            .get()
            .then()
            .statusCode(200);
    }

    @Test public void crearUsuario() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";   
        given()
        .baseUri("https://reqres.in/api")
        .contentType(ContentType.JSON)
        .body(body)
            .when()
            .post("/users")
            .then()
            .statusCode(201)
            .log().all();
    }

    @Test
    public void actualizarUsuario() {
        String body = "{\n" +
                "    \"nombresuli\": \"Patito\",\n" +
                "    \"chamba\": \"Free Rango\"\n" +
                "}";
        given()
                .baseUri("https://reqres.in/api")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/users/690")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void borrarUsuario() {
        given()
                .baseUri("https://reqres.in/api")
                .when()
                .delete("/users/690")
                .then()
                .statusCode(204)
                .log().all();
    }
    
}
