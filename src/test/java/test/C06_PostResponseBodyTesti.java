package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C06_PostResponseBodyTesti {

    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void test01(){
        // 1- URl ve request body hazirla

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqbody = new JSONObject();
        reqbody.put("title","API");
        reqbody.put("body","API ogrenmek ne guzel");
        reqbody.put("userId",10);
        System.out.println(reqbody);

        // 2- Expected Data hazirla

        // 3- Responce kaydet

        Response response = given().
                                   contentType(ContentType.JSON).
                            when().
                                   body(reqbody.toString()).post(url);

        response.prettyPrint();

        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("title", equalTo("API")).
                body("userId", lessThan(100)).
                body("body",Matchers.containsString("API"));

    }
    @Test
    public void test02(){
        // 1- URl ve request body hazirla

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqbody = new JSONObject();
        reqbody.put("title","API");
        reqbody.put("body","API ogrenmek ne guzel");
        reqbody.put("userId",10);
        System.out.println(reqbody);

        // 2- Expected Data hazirla

        // 3- Responce kaydet

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqbody.toString()).post(url);

        response.prettyPrint();

        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("title", equalTo("API"),
                        "userId", lessThan(100),
                         "body",containsString("API"));


    }
}
