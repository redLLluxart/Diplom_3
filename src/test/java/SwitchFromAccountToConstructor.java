import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SwitchFromAccountToConstructor extends TestTemplate {
    @Test
    @DisplayName("Переход в Личный кабинет неавторизованного пользователя")
    @Description("Проверка, что открывается раздел Личный кабинет(форма входа), когда пользователь не авторизован")
    public void goToProfilePageWithoutAuthTest() {
        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .isSignInBtnDisplayed();

;       assertTrue("Форма входа не открывается у не авторизованных пользователей!",actual);
    }

    @Test
    @DisplayName("Переход в Личный кабинет авторизованного пользователя")
    @Description("Проверка, что открывается раздел Личный кабинет(профиль), когда пользователь авторизован")
    public void goToProfilePageWithAuthTest() {
        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickSingInCentralBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();


        assertTrue("Профиль не открывается у авторизованных пользователей!",actual);
    }

    @Test
    @DisplayName("Переход из Личного кабинета неавторизованного пользователя в Конструктор")
    @Description("Проверка, что открывается раздел Конструктор, когда пользователь не авторизован")
    public void goFromProfilePageWithoutAuthTest() {
        Boolean actual = new MainPage(driver)
                .clickSingInCentralBtn()
                .clickConstructorBtn()
                .isBunsIsDisplayed();

        assertTrue("Раздел Конструктор не открывается у не авторизованных пользователей!",actual);
    }

    @Test
    @DisplayName("Переход из Личного кабинета авторизованного пользователя в Конструктор")
    @Description("Проверка, что открывается раздел Конструктор и есть кнопка Оформить заказ, когда пользователь авторизован")
    public void goFromProfilePageWithAuthTest() {
        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickSingInCentralBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .clickConstructorBtn()
                .isBunsIsDisplayed();

        assertTrue("Раздел Конструктор не открывается у авторизованных пользователей!",actual);
    }

    @Test
    @DisplayName("Переход из Личного кабинета авторизованного пользователя по клику на логотип")
    @Description("Проверка, что открывается главная станица, когда авторизованный пользователь кликнул на логотип")
    public void goFromProfilePageWithAuthWhenClickLogoTest() {
        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickSingInCentralBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .clickLogoBtn()
                .isBunsIsDisplayed();

        assertTrue("Главная станица, не открывается, когда авторизованный пользователь кликнул на логотип",actual);

    }
}
