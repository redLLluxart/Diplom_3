import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends TestTemplate{

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка, что можно перейти в раздел 'Булки' ")
    public void openCatalogBunsTest() {
        Boolean actual = new MainPage(driver)
                .clickSaucesBtn()
                .clickBunBtn()
                .isBunsIsDisplayed();

        assertTrue("Вкладка Булки не отображается!",actual);
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка, что можно перейти в раздел 'Соусы' ")
    public void openCatalogSaucesTest() {
        Boolean actual = new MainPage(driver)
                .clickSaucesBtn()
                .isSaucesIsDisplayed();

        assertTrue("Вкладка Соусы не отображается!",actual);
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка, что можно перейти в раздел 'Начинки' ")
    public void openCatalogFillingsTest() {
        Boolean actual = new MainPage(driver)
                .clickFillingsBtn()
                .isFillingsIsDisplayed();

        assertTrue("Вкладка Начинки не отображается!",actual);
    }

}
