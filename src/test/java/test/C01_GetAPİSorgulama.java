package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.path.json.JsonPath.given;

import static io.restassured.RestAssured.given;

public class C01_GetAPİSorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */
    // 1- Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirlariz
    // 2- Eger soruda bize verilmisse EXpected Data hazirlariz
    // 3- Bize donen ResponceYi Actual Data olarak kaydederiz
    // 4- Expected Data ile Actual Data nin karsilastirilmasi, Assertion

    @Test
    public void get01(){

        // 1- Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirlariz

        String url = "https://restful-booker.herokuapp.com/booking/112";

        // 2- Eger soruda bize verilmisse Expected Data hazirlariz

        // 3- Bize donen ResponceYi Actual Data olarak kaydederiz

        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status Code  : " + response.statusCode());
        System.out.println("Content Type  : " + response.getContentType());
        System.out.println("Server Header'inin Degeri  : " + response.getHeader("Server"));
        System.out.println("Status Line  : " + response.getStatusLine());
        System.out.println("Response suresi  : " + response.getTime());



        // 4- Expected Data ile Actual Data nin karsilastirilmasi, Assertion



    }

}
