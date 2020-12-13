import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("telepnev")
@Feature("Контакты")
public class CheckingContatsTests {
    ContactData contact = new ContactData();
    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия 7 контактных данных на странице")
    public void openMainContactPageTest() {
        step("Открываем страницу контактов", () -> {open("https://ibs.ru/contacts/");
            $("h1").shouldHave(text("Контакты"));});
        step("Проверяем что кол-во офисов равно 7", () -> $$(".aside-navigation__item").shouldHaveSize(7));
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия контактных данных на странице офиса Москва (головной офис)")
    public void verifyMoscowAddressTest() {
        step("Открываем страницу контактов", () -> open("https://ibs.ru/contacts/"));
        step("Переходим на страницу контактов Московского офиса", () -> $(byText("Москва (головной офис)")).click());
        step("Сверяем адрес офиса в Москве", () -> $(".contacts__info").shouldHave(text(contact.MoscowAddress)));
        step("Сверяем телефона офиса в Москве", () -> $(".contacts__info").shouldHave(text(contact.MoscowPhone)));
        step("Сверяем юр. адрес офиса в Москве", () -> {$(byText("Юридический и почтовый адрес")).click();
            $(".view-address-block__content").shouldHave(text(contact.MoscowLegalAddress));});
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия контактных данных на странице офиса Нижний Новгород")
    public void verifyNizhnyNovgorodAddressTest() {
        step("Открываем страницу контактов", () -> open("https://ibs.ru/contacts/"));
        step("Переходим на страницу контактов Нижний Новгород", () -> $(byText("Нижний Новгород")).click());
        step("", () -> $(".contacts__address").shouldNotBe(empty));
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия контактных данных на странице офиса Пенза")
    public void verifyPenzaAddressTest() {
        step("Открываем страницу контактов", () -> open("https://ibs.ru/contacts/"));
        step("Переходим на страницу контактов Пенза", () -> $(byText("Пенза")).click());
        step("", () -> $(".contacts__address").shouldNotBe(empty));
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия контактных данных на странице офиса Пермь")
    public void verifyPermAddressTest() {
        step("Открываем страницу контактов", () -> open("https://ibs.ru/contacts/"));
        step("Переходим на страницу контактов Пермь", () -> $(byText("Пермь")).click());
        step("", () -> $(".contacts__address").shouldNotBe(empty));
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия контактных данных на странице офиса Ульяновск")
    public void verifyUlyanovskAddressTest() {
        step("Открываем страницу контактов", () -> open("https://ibs.ru/contacts/"));
        step("Переходим на страницу контактов Ульяновск", () -> $(byText("Ульяновск")).click());
        step("", () -> $(".contacts__address").shouldNotBe(empty));
    }

    @Test
    @Story("Проверка контактных данных")
    @DisplayName("Проверка наличия контактных данных на странице офиса Санкт-Петербург")
    public void verifySaintPetersburgAddressTest() {
        step("Открываем страницу контактов", () -> open("https://ibs.ru/contacts/"));
        step("Переходим на страницу контактов офиса в Санкт-Петербурге", () -> $(byText("Санкт-Петербург")).click());
        step("Сверяем адрес офиса в Санкт-Петербурге", () -> $(".contacts__info").shouldHave(text(contact.SaintPetersburgAddress)));
        step("Сверяем телефона офиса в Санкт-Петербурге", () -> $(".contacts__info").shouldHave(text(contact.SaintPetersburgPhone)));
        step("Сверяем юр. адрес офиса в Санкт-Петербурге", () -> {$(byText("Юридический и почтовый адрес")).click();
            $(".view-address-block__content").shouldHave(text(contact.SaintPetersburgLegalAddress));});
    }
}
