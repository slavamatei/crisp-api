package crisp.step_definitions;

import crisp.utilities.ConfigurationReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class Hooks {
    @Before
    public void init(){
        RestAssured.baseURI = ConfigurationReader.getProperty("baseURI");
        RestAssured.basePath = ConfigurationReader.getProperty("queryEndpoint");
    }
}
