package Examples;

import org.junit.Test;
import static com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class chapter5 {
    @Test
    public void expectBeverlyHills() {

        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("response.places.place.placeName", equalTo("Beverly Hills"));
    }

    @Test
    public void ResponseBodyExpectKropp() {
        given().
                when().
                get("http://api.zippopotam.us/de/24848").
                then().
                assertThat().
                body("response.places.place[2].placeName", equalTo("Kropp"));
    }
}
