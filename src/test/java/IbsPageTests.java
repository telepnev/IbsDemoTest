
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testHelper.HelperTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
    @Story("Пользователь переходит на главную страницу")
    @DisplayName("Проверяем что главная страница открывается")
    public void openMainPageTest() {
        step("Проверяем что главная страница открывается", () -> {
            open(Url);
            $("h1").shouldHave(text("Мы создаем решения"));
        });
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Поиск публикаций, новостей, решений, проектов")
    public void siteSearchTest() {
        step("Проверяем работу поиска по сайту ищем = " + searchingString, () -> helperTests.search(searchingString));
        step("Переходим по ссылке искомой фразы", () -> $x("//a[@href='/business-apps/financial-systems/upravlenie-finansami-i-uchet/']").click());
    }

    @Test
    @Story("Пользователь переходит в раздел 'Управление документооборотом'")
    @DisplayName("БИЗНЕС-ПРИЛОЖЕНИЯ")
    public void businessApplicationsTest() {
        step("Открываем главную страницу", () ->{open("https://ibs.ru/");});
        step("Close popup", () -> helperTests.closePopup());
        step("Переходим в 'БИЗНЕС-ПРИЛОЖЕНИЯ'", () ->{$(".header__menu").click();
            $(byText("Бизнес-приложения")).click();
            $("h1").shouldHave(text("Бизнес-приложения"));});
        step("Переходим в 'Управление документооборотом'", () -> {$x("//a[@href='/products/workflow/upravlenie-dokumentooborotom/']").click();
            $("h1").shouldHave(text("Управление документооборотом"));});
    }

    @Test
    @Story("Пользователь должен иметь возможность запросить контакты или подробности из раздела 'Управление документооборотом'")
    @DisplayName("Бизнес-Приложения")
    public void requestAdditionalInformationTest() {
        step("Переходим на страницу 'Управление документооборотом'", () -> open("https://ibs.ru/products/workflow/upravlenie-dokumentooborotom/"));
        step("Close popup", () -> helperTests.closePopup());
        step("Заполняем Имя", () -> $("#form_text_59").val(helperTests.getFirstName()).pressTab());
        step("Заполняем Название компании", () -> $("#form_text_60").val(helperTests.getCompanyName()).pressTab());
        step("Заполняем Город", () -> $("#form_text_61").val(helperTests.getCity()).pressTab());
        step("Заполняем Телефон", () -> $("#form_text_62").val(helperTests.getPhone()).pressTab());
        step("Заполняем Email", () -> $("#form_email_63").val(helperTests.getEmail()).pressTab());
        step("Заполняем Ваше сообщение", () -> $("#form_textarea_64").val(helperTests.getTextMessage()).pressTab());
        $("#info_click").click();

        sleep(4000);
    }

}
