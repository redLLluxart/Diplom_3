import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SignInTest extends TestTemplate {

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти в аккаунт' на главной странице")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void singInWithBtnOnHeadPageTest() {
        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickSignInCentralBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();


        assertTrue("В авторизованном профиле не отображается информационное сообщение!",actual);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Личный кабинет'")
    public void singInWithProfileBtnTest() {

        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();


        assertTrue("В авторизованном профиле не отображается информационное сообщение!",actual);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме регистрации")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnRegistrationPageTest() {
        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .clickRegistrationBtn()
                .clickSingInBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();

        assertTrue("В авторизованном профиле не отображается информационное сообщение!",actual);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме восстановления пароль")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnForgottPasswordPageTest() {
        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .clickForgottPasswordBtn()
                .clickSingInBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();

        assertTrue("В авторизованном профиле не отображается информационное сообщение!",actual);
    }
}
