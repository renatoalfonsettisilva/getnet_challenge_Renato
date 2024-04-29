import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CreateResourceTest {

    @Test
    public void testCreateResource() {
        RestAssured.baseURI = "https://reqres.in/api";

        RequestBody requestBody = new RequestBody();
        requestBody.setId("12345");
        requestBody.setName("Renato Silva");
        requestBody.setJob("QA");
        requestBody.setcreatedAt("01/01/2024");

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("id", notNullValue("12345"))
            .body("name", equalTo("Renato Silva"))
            .body("job", equalTo("QA"))
            .body("createdAt", notNullValue("01/01/2024"));
    }
}
