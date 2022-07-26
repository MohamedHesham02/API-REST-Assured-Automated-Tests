package Examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Request;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class chapter4 {
    public static RequestSpecification requestSpec;
    @BeforeClass
    public static void createRequestSpec(){
        requestSpec = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us").build();
    }
    @Test
    public void createTestFromReqSpec(){
        given().spec(requestSpec).when().get("us/90210").then().assertThat().statusCode(200);
    }
    public static ResponseSpecification responseSpec;
    @BeforeClass
    public static void createResponseSpec(){
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }
    @Test
    public void createTestFromResSpec(){
        given().spec(requestSpec).when().get("us/90210").then().spec(responseSpec).assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }
    @Test
    public void extractFromTest(){
        String placeName = given().spec(requestSpec).when().get("us/90210").then().extract().path("places[0].'place name'");
        Assert.assertEquals(placeName, "Beverly Hills", "The place name is not the expected");
    }
}
