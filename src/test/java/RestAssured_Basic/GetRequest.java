package RestAssured_Basic;

import io.restassured.RestAssured;

public class GetRequest {

    public static void main(String[] args) {

        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Enter the Pincode: ");
//                String pincode = scanner.nextLine();

        // Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // bath Path - /IN/560016

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/413512")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
