import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SignOutTest extends TestTemplate{

    @Test
    @DisplayName("Выход из аккаунта авторизованного пользователя")
    @Description("Проверка, что можно выйти из аккаунта авторизованного пользователя")
    public void canSingOutFromProfileTest() {

        userClient.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUser(user.getEmail(),user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .clickSingOutBtn()
                .isSignInBtnDisplayed();

        assertTrue("Пользователь все еще авторизован!",actual);
    }
}
