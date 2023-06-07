package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class RegistrationPage {

    //Локатор поля Имя
    private final By name = By.xpath("//label[contains(text(),'Имя')]/../input");
    //Локатор поля  Email
    private final By email = By.xpath("//label[contains(text(),'Email')]/../input");
    //Локатор поля Пароль
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Локатор кнопки Зарегистрироваться
    private final By registrationBtn = By.xpath(".//button[text()='Зарегистрироваться']");
    //Локатор кнопки вход
    private final By singInBtn = By.xpath("//a[text()='Войти']");

    private final WebDriver driver;

    public RegistrationPage setName(String userName) {
        driver.findElement(name).sendKeys(userName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
        return this;
    }

    public RegistrationPage setPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
        return this;
    }

    public void clickRegisterBtn() {
        driver.findElement(registrationBtn).click();
    }

    public LoginPage registerUser(String name,String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterBtn();
        return new LoginPage(driver);
    }

    public LoginPage clickSingInBtn() {
        driver.findElement(singInBtn).click();
        return new LoginPage(driver);
    }

}
