import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testHelper.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("telepnev")
@Feature("Центр аутсорсинга и сопровождения ИТ-систем")

public class CheckingHowLinksWorkTests extends BaseTest {

    final String vkUrl = "IBS | ВКонтакте";
    final String faceBookUrl = "IBS - Главная | Facebook";
    final String inUrl = "Доступ к ресурсу заблокирован";
    final String habrUrl = "IBS, Москва - IBS – технологический партнер лидеров экономики / Статьи / Хабр";
    final String twitterUrl = "Профиль / Твиттер";
    final String youtuberUrl = "IBS ru - YouTube";

    @Test
    @Story("Пользователь переходит по соц ссылкам на странице Центр аутсорсинга")
    @DisplayName("Переход в IBS - Главная | Facebook")
    public void checkFaceBookUrlTest() {
        step("Переходим на страницу Центр аутсорсинга и сопровождения ИТ-систем", () -> open("https://ibs.ru/ibsservice/"));
        step("Кликаем по иконке 'Facebook'", () -> {
            $x("//ul[@class='social-links__list']//li[1]").click();
        });
        step("Проверка перенаправления на страницу 'IBS - Главная | Facebook'", () -> {
            String titleString = switchTo().window(1).getTitle();
            Assertions.assertEquals(faceBookUrl, titleString, "Address link not equals!!!");
        });
    }

    //TODO уточнить или уборать проверку "inUrl"
    @Test
    @Story("Пользователь переходит по соц ссылкам на странице Центр аутсорсинга")
    @DisplayName("Переход в IBS ru - in")
    public void checkInUrlTest() {
        step("Переходим на страницу Центр аутсорсинга и сопровождения ИТ-систем", () -> open("https://ibs.ru/ibsservice/"));
        step("Кликаем по иконке 'in'", () -> {
            $x("//ul[@class='social-links__list']//li[2]").click();
        });
        step("Проверка перенаправления на страницу 'Доступ к ресурсу заблокирован'", () -> {
            String titleString = switchTo().window(1).getTitle();
            Assertions.assertEquals(inUrl, titleString, "Address link not equals!!!");
        });
    }

    @Test
    @Story("Пользователь переходит по соц ссылкам на странице Центр аутсорсинга")
    @DisplayName("Переход в IBS | ВКонтакте")
    public void checkVkUrlTest() {
        step("Переходим на страницу Центр аутсорсинга и сопровождения ИТ-систем", () -> open("https://ibs.ru/ibsservice/"));
        step("Кликаем по иконке 'ВКонтакте'", () -> {
            $x("//ul[@class='social-links__list']//li[3]").click();
        });
        step("Проверка перенаправления на страницу 'IBS | ВКонтакте'", () -> {
            String titleString = switchTo().window(1).getTitle();
            Assertions.assertEquals(vkUrl, titleString, "Address link not equals!!!");
        });
    }

    @Test
    @Story("Пользователь переходит по соц ссылкам на странице Центр аутсорсинга")
    @DisplayName("Переход в IBS ru - Хабр")
    public void checkHabrUrlTest() {
        step("Переходим на страницу Центр аутсорсинга и сопровождения ИТ-систем", () -> open("https://ibs.ru/ibsservice/"));
        step("Кликаем по иконке 'Хабр'", () -> {
            $x("//ul[@class='social-links__list']//li[4]").click();
        });
        step("Проверка перенаправления на страницу 'IBS ru - Хабр'", () -> {
            String titleString = switchTo().window(1).getTitle();
            Assertions.assertEquals(habrUrl, titleString, "Address link not equals!!!");
        });
    }

    @Test
    @Story("Пользователь переходит по соц ссылкам на странице Центр аутсорсинга")
    @DisplayName("Переход в IBS Профиль / Твиттер")
    public void checkTwitterUrlTest() {
        step("Переходим на страницу Центр аутсорсинга и сопровождения ИТ-систем", () -> open("https://ibs.ru/ibsservice/"));
        step("Кликаем по иконке 'Твиттер'", () -> {
            $x("//ul[@class='social-links__list']//li[5]").click();
        });
        step("Проверка перенаправления на страницу 'IBS ru - Твиттер'", () -> {
            String titleString = switchTo().window(1).getTitle();
            Assertions.assertEquals(twitterUrl, titleString, "Address link not equals!!!");
        });
    }

    @Test
    @Story("Пользователь переходит по соц ссылкам на странице Центр аутсорсинга")
    @DisplayName("Переход в IBS ru - YouTube")
    public void checkYouTuberUrlTest() {
        step("Переходим на страницу Центр аутсорсинга и сопровождения ИТ-систем", () -> open("https://ibs.ru/ibsservice/"));
        step("Кликаем по иконке 'YouTube'", () -> {
            $x("//ul[@class='social-links__list']//li[6]").click();
        });
        step("Проверка перенаправления на страницу 'IBS ru - YouTube'", () -> {
            String titleString = switchTo().window(1).getTitle();
            Assertions.assertEquals(youtuberUrl, titleString, "Address link not equals!!!");
        });
    }
}
