package Examples;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

@RunWith(DataProviderRunner.class)
public class chapter3 {
    @DataProvider
    public static Object[][] ZipCodeAndPlace(){
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
                {"nl","5255","Amsterdam"}
        };
    }

    @Test
    @UseDataProvider("ZipCodeAndPlace")
    public void checkActualResult(String CountryCode, String ZipCode, String ExpectedResult){
        given().
                pathParam("countryCode", CountryCode).
                pathParam("zipCode", ZipCode).
                when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().assertThat().
                body("places[0].'place name'", equalTo(ExpectedResult));
    }
}
