package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {


  protected RequestSpecification specJsonPlace;

    @Before
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder().
                            setBaseUri("https://jsonplaceholder.typicode.com").
                            build();
    }
    /*
               {
           "title":"Ali",
           "body":"Merhaba",
           "userId":10,
           "id":70
           }
            */

    public JSONObject requestBodyOlusturJSON (){
        JSONObject reqBodyJson = new JSONObject();
        reqBodyJson.put("userId",10);
        reqBodyJson.put("id",70);
        reqBodyJson.put("title","Ali");
        reqBodyJson.put("body","Merhaba");
        return reqBodyJson;

}

}
