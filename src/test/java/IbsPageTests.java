
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testHelper.HelperTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Owner("telepnev")
@Feature("Главная страница")
public class IbsPageTests {
    HelperTests helperTests = new HelperTests();
    final String Url = "https://ibs.ru/";
    final String searchingString = "Управление финансами и учет";
    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    @DisplayName("Проверяем что главная страница открывается")
    public void openMainPageTest() {
        step("Проверяем что главная страница открывается", () -> {
            open(Url);
            $("h1").shouldHave(text("Мы создаем решения"));
        });
    }

    @Test
    @DisplayName("Поиск публикаций, новостей, решений, проектов")
    public void siteSearchTest() {
        step("Проверяем работу поиска по сайту ищем = " + searchingString, () -> helperTests.search(searchingString));
        step("Переходим по ссылке искомой фразы", () -> $x("//a[@href='/business-apps/financial-systems/upravlenie-finansami-i-uchet/']").click());

    }
}
