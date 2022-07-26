package Examples;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class chapter1 {
    @Test
    public void test1(){

        given().
        when().
        get("http://zippopotam.us/us/90210").
        then().assertThat().
        body("places[0].'state'", equalTo("California"));
    }
    @Test
    public void test2(){

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().
                body("places[0].'state'", equalTo("New York"));
    }
    @Test
    public void test3(){

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }
    @Test
    public void test4(){

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().
                body("places.'place name'", hasItem("Beverly Hills")); /// index 0 is removed in body 1st arg. due to the following:
                // here places will be turned from a collection(dictionary) of elements to set of elements(array)
    }
    @Test
    public void test5(){

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().assertThat().
                body("places.'place name'", hasSize(1)); // size is not for no. of chars, but for no. of element in place name

    }
}
