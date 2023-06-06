import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static Utils.Util.randomString;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends TestTemplate {

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными ")
    public void registerNewUserTest() {

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .clickRegistrationBtn()
                .registerUser(user.getName(),user.getEmail(), user.getPassword())
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();


        assertTrue("В авторизованном профиле не отображается информационное сообщение!",actual);

    }
    @Test
    @DisplayName("Регистрация пользователя с валидными данными через API")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными через API")
    public void registerNewUserWithApiTest() {

        userClient.create(user);
        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        assertTrue("В авторизованном профиле не отображается информационное сообщение!",actual);
    }

    @Test
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверка, что нельзя зарегистрировать пользователя с паролем менее 6 символов")
    public void registerNewUserWithShortPassTest() {

        user.setPassword(randomString(4));

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUserWithWrongPassword(user.getEmail(), user.getPassword())
                .isErrorAboutShortPassword();

        assertTrue("Пароль верный!",actual);
    }

}
