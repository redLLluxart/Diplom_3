package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class ForgotPassPage {

    private final By singInBtn = By.xpath(".//a[text()='Войти']"); //кнопка вход

    private final WebDriver driver;

    public LoginPage clickSingInBtn() {
        driver.findElement(singInBtn).click();
        return new LoginPage(driver);
    }
}
