import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C13_Get_ExpectedDataOlusturma {

    @Test
    public void test(){
/*        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
        yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
        Response body :
        {
            "userId": 3,
                "id": 22,
                "title": "dolor sint quo a velit explicabo quia nam",
                "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
            um mollitia molestiae aut atque rem suscipitnam impedit esse"
        }*/

        // end point ve request body

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // expected data olustur

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear\n" +
                "            um mollitia molestiae aut atque rem suscipitnam impedit esse");

        // request gonder ve donen response i kaydet

        Response response = given().when().get(url);
        response.prettyPrint();
        // Assertion

    /*    response
                .then()
                .assertThat()
                .body("userId",equalTo(3),"id",equalTo(22)
                ,"title",equalTo("dolor sint quo a velit explicabo quia nam"));*/


        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
    }
}
