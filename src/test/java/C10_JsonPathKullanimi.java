import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void test(){
        JSONObject kisiBilgileriJsonObj = new JSONObject();
        JSONObject adresJsonObj = new JSONObject();

        JSONArray phoneNumbers = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObj = new JSONObject();

        kisiBilgileriJsonObj.put("firstName","John");
        kisiBilgileriJsonObj.put("lastName","Doe");
        kisiBilgileriJsonObj.put("age",26);
        adresJsonObj.put("streetAddress","naist street");
        adresJsonObj.put("city","nara");
        adresJsonObj.put("postalCode","630-0192");
        cepTelJsonObj.put("type","iPhone");
        cepTelJsonObj.put("number","0123-4567-8888");
        evTelJsonObj.put("type","home");
        evTelJsonObj.put("number","0123-4567-8910");
        phoneNumbers.put(cepTelJsonObj);
        phoneNumbers.put(evTelJsonObj);
        kisiBilgileriJsonObj.put("address",adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",phoneNumbers);

        System.out.println(kisiBilgileriJsonObj);






    }
}
