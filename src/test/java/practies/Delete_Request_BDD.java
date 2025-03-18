package practies;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Delete_Request_BDD {
@Test
    public void Test_Delete()
    { int id=250;
        RestAssured.given()
                .baseUri("https://reqres.in/")
                .basePath("/api/users/"+id)
                .when()
                .delete()
                .then().log().all().statusCode(204).statusLine("HTTP/1.1 204 No Content");
    }
}
