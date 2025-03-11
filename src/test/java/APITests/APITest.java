package APITests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

    @Test
    public void testRickAndMortyAPI() {
        given()
            .baseUri("https://rickandmortyapi.com/api")
            .when()
            .get("/character/1")
            .then()
            .statusCode(200)
            .body("name", equalTo("Rick Sanchez"))
            .body("status", equalTo("Alive"))
            .body("species", equalTo("Human"))
            .body("gender", equalTo("Male"));       
    }
    
}
