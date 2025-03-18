package practies;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Delete_Request_Non_BDD {


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse vadlidateResponse;



    @Test
    public void Test_Delete()
    { int id=250;
        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/");
        requestSpecification.basePath("/api/users/2"+id);
        response= requestSpecification.when().delete();
        vadlidateResponse=response.then().log().all().statusCode(204).statusLine("HTTP/1.1 204 No Content");

    }
}
