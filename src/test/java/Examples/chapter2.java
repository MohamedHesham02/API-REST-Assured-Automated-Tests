package Examples;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class chapter2 {
    @Test
    public void test1(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().
                statusCode(200);
    }
    @Test
    public void test2(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().
                statusCode(201);
    }
    @Test
    public void test3(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().contentType(ContentType.JSON);    // contentType(application/json);
    }
    @Test
    public void test4(){
        given().log().
                all().
                when().
                get("http://zippopotam.us/us/90210").
                then().log().body();
    }

}
