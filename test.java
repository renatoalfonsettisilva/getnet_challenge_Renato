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
        requestBody.setName("Renato Silva");
        requestBody.setJob("QA");

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Renato Silva"))
            .body("job", equalTo("QA"))
            .body("id", notNullValue())
            .body("createdAt", notNullValue());
    }
}
