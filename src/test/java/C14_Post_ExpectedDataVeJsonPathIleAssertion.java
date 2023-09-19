import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test(){

       /* https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye
       sahip bir POST request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
            "firstname" : "Ahmet",
                "lastname" : “Bulut",
            "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
            "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
        },
            "additionalneeds" : "wi-fi"
        }


        Response Body
{
"bookingid": 24,
"booking": {
    "firstname": "Ahmet",
    "lastname": "Bulut",
    "totalprice": 500,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
    },
"additionalneeds": "wi-fi"
}
}


*/


        // end point ve request body

        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJson = new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2021-06-01");
        rezervasyonTarihleriJson.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("additionalneeds","wi-fi");
        requestBody.put("bookingdates",rezervasyonTarihleriJson);


        //expected data

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);

        // request gonder ve donen response i kaydet

        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        // assartion

        JsonPath renponseJsonPath = response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                renponseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                renponseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                renponseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                renponseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                renponseJsonPath.get("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject(
                "bookingdates").get("checkin"),renponseJsonPath.
                get("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject(
                "bookingdates").get("checkout"),renponseJsonPath.
                get("booking.bookingdates.checkout"));
    }
}
