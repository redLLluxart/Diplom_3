import data.User;
import extensions.WebDriverFactory;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import user.UserClient;

import java.time.Duration;

import static user.UserGenerator.getRandomUser;

public class TestTemplate {
    WebDriver driver;
    UserClient userClient;
    User user;
    private String bearerToken;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.get("chrome");
        user = getRandomUser();
        userClient = new UserClient();
    }

    @After
    public void teardown() {
        driver.quit();
        if (user != null) {
            ValidatableResponse responseLogin = userClient.login(user);
            bearerToken = responseLogin.extract().path("accessToken");
            if (bearerToken == null) {
                return;
            }
            userClient.delete(bearerToken);
        }
    }

}
