package pages;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class MainPage {
    private final WebDriver driver;

    //Локатор кнопки личный кабинет
    private final By personalAccountBtn = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    //Локатор кнопки войти на главной страницк
    private final By singInMainPageBtn = By.xpath(".//button[text()='Войти в аккаунт']");
    //Локатор вкладки булки
    private final By bunBtn = By.xpath(".//div[span[text()='Булки']]");
    //Локатор вкладки соусы
    private final By saucesBtn = By.xpath(".//div[span[text()='Соусы']]");
    //Локатор вкладки начинки
    private final By fillingsBtn = By.xpath(".//div[span[text()='Начинки']]");
    //Локатор булок
    private final By bun = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    //Локатор соусов
    private final By sauces = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    //Локатор начинки
    private final By fillings = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");


    public LoginPage clickPersonalAccountBtn(){
        driver.findElement(personalAccountBtn).click();
        return new LoginPage(driver);
    }

    public ProfilePage clickPersonalAccountBtnWithAuthorizedUser(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountBtn));

        driver.findElement(personalAccountBtn).click();
        return new ProfilePage(driver);
    }

    public LoginPage clickSignInCentralBtn() {
        driver.findElement(singInMainPageBtn).click();
        return new LoginPage(driver);
    }

    public MainPage clickBunBtn() {
        driver.findElement(bunBtn).click();
        return new MainPage(driver);
    }

    public MainPage clickSaucesBtn() {
        driver.findElement(saucesBtn).click();
        return new MainPage(driver);
    }

    public MainPage clickFillingsBtn() {
        driver.findElement(fillingsBtn).click();
        return new MainPage(driver);
    }
    public boolean isBunsIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bun));

        return driver.findElement(bun).isDisplayed();
    }

    public boolean isSaucesIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauces));

        return driver.findElement(sauces).isDisplayed();
    }

    public boolean isFillingsIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillings));

        return driver.findElement(fillings).isDisplayed();
    }

}
