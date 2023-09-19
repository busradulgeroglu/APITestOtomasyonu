import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
            public void test(){
          /* https://restful-booker.herokuapp.com/booking/10 url’ine bir GET
    request gonderdigimizde
    donen Response’un,
    status code’unun 200,
    ve content type’inin application-json,
    ve response body’sindeki
"firstname“in, "Susan",
    ve "lastname“in, "Jackson",
    ve "totalprice“in, 1000 den kücük olduğunu,
    ve "depositpaid“in, false,
    ve "additionalneeds“in, bos bırakılmadığını
    oldugunu test edin*/

        // request body ve end point hazırlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // expected data hazırlama
        // request gönderip dönen responsu kaydetme

        Response response = given().when().get(url);


        // Assertion

/*        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Jim"))
                .body("lastname",Matchers.equalTo("Wilson"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(false))
                .body("additionalneeds",Matchers.notNullValue());*/


        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Brown"),
                        "totalprice",lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds",nullValue()
                );

    }

}
