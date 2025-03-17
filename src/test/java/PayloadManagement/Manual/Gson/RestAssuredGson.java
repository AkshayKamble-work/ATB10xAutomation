package PayloadManagement.Manual.Gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;

public class RestAssuredGson

{
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void Create_Booking() {
        Booking booking = new Booking();
        booking.setFirstname("Akshay");
        booking.setLastname("Kamble");
        booking.setDepositpaid(true);
        booking.setTotalprice(123);

        // Create an instance of BookingDates
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-17");
        bookingDates.setCheckout("2024-03-17");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        // Convert Booking object to JSON string
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);


        requestSpecification=RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON)
                .body(jsonStringBooking)
                .log().all();

      response= requestSpecification.when().post();

      validatableResponse=response.then().log().all();
     validatableResponse.statusCode(200);
        // Case1 - extract() - Direct Extraction
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        Assert.assertEquals(firstname1,"Akshay");

        assertThat(firstname1).isNotNull().isNotEmpty().isNotBlank().isEqualTo("Akshay");

        // Case 2 - jsonPath.getString("")  JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId  = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);
        String jsonResponseString1  = response.asString();
        // Case 3 - DeSer - Extraction
        //  Response - De Ser another Response Class
        BookingResponse bookingResponse = gson.fromJson(jsonResponseString1,BookingResponse.class);

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Akshay").isNotNull().isNotEmpty();


    }


}
