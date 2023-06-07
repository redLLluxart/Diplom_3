package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class LoginPage {

    private final WebDriver driver;

    //Локатор кнопки Зарегистрироваться
    private final By registrationBtn = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //Локатор кнопки Войти
    private final By signInBtn = By.xpath(".//button[text()='Войти']");
    //Локатор поля Email
    private final By email = By.xpath("//label[contains(text(),'Email')]/../input");
    //Локатор поля Пароль
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Локатор кнопки личный кабинет
    private final By personalAccountBtn = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    //Локатор информации о некорректном пароле
    private final By errorShortPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    //Локатор кнопки восстановить пароль
    private final By forgottPasswordBtn = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");
    //Локатор кнопки конструктора
    private final By constructorBtn = By.xpath(".//p[text()='Конструктор']");

    public RegistrationPage clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
        return new RegistrationPage(driver);
    }

    public LoginPage clickSignInBtn() {
        driver.findElement(signInBtn).click();
        return this;
    }

    public void setEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickPersonalAccountBtn() {
        driver.findElement(personalAccountBtn).click();
    }
    public MainPage signInUser(String userEmail, String userPassword){

        clickPersonalAccountBtn();
        setEmail(userEmail);
        setPassword(userPassword);
        clickSignInBtn();

        return new MainPage(driver);
    }

    public LoginPage signInUserWithWrongPassword(String userEmail, String userPassword){

        clickPersonalAccountBtn();
        setEmail(userEmail);
        setPassword(userPassword);
        clickSignInBtn();

        return new LoginPage(driver);
    }

    public boolean isErrorAboutShortPassword() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorShortPassword));

        return driver.findElement(errorShortPassword).isDisplayed();
    }

    public ForgotPassPage clickForgottPasswordBtn() {

        WebElement element = driver.findElement(forgottPasswordBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(forgottPasswordBtn).click();

        return new ForgotPassPage(driver);
    }

    public boolean isSignInBtnDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));

        return driver.findElement(signInBtn).isDisplayed();
    }

    public MainPage clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
        return new MainPage(driver);
    }

}
