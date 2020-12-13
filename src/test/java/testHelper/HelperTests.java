package testHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HelperTests {
    final String Url = "https://ibs.ru/";

    public void search(String string) {
        open(Url);
        $x("//input[@name='q']").val(string).pressEnter();
        $(".search-result__title").shouldHave(text(string));
    }

}
