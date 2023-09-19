import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {
    @Test
    public void get01(){
// https://restful-booker.herokuapp.com/booking/10  url ine bir get request
// gönderdiğimizde donen responsu yazdırın
        // request body ve end point hazırlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // expected data hazırlama
        // request gönderip dönen responsu kaydetme

        Response response = given().when().get(url);
        response.prettyPrint();

        // Assertion

    }

}
