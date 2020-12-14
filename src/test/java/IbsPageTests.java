
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
        step("Переходим в 'БИЗНЕС-ПРИЛОЖЕНИЯ'", () ->{$(".header__menu").click();
            $(byText("Бизнес-приложения")).click();
            $("h1").shouldHave(text("Бизнес-приложения"));});
        step("Переходим в 'Управление документооборотом'", () -> {$x("//a[@href='/products/workflow/upravlenie-dokumentooborotom/']").click();
            $("h1").shouldHave(text("Управление документооборотом"));});
    }

    @Test
    @Story("Пользователь должен иметь возможность запросить контакты или подробности из раздела 'Управление документооборотом'")
    @DisplayName("БИЗНЕС-ПРИЛОЖЕНИЯ")
    public void requestAdditionalInformationTest() {
        open("https://ibs.ru/products/workflow/upravlenie-dokumentooborotom/");
        //TODO  убрать попап, предупреждение об куки
        switchTo().frame($x("//a[text()='Принимаю условия']")).close();
        $("#form_text_59").val(helperTests.getFirstName());
        $("#form_text_60").val(helperTests.getCompanyName());
        $("#form_text_61").val(helperTests.getCity());
        $("#form_text_62").val(helperTests.getPhone());
        $("#form_text_63").val(helperTests.getEmail());
        $("#form_textarea_64").val(helperTests.getTextMessage());


        sleep(4000);
    }

}
