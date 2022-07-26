package Examples;

import org.junit.Test;
import org.testng.Assert;
import javax.xml.stream.Location;

import static io.restassured.RestAssured.given;

public class chapter6 {

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
        Location location =
                given().
                        when().
                        get("http://api.zippopotam.us/us/90210").
                        as(Location.class);

        Assert.assertEquals("Beverly Hills",
                location.ge);
}
