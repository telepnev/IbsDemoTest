package testHelper;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HelperTests {
    Faker faker = new Faker();
    final String Url = "https://ibs.ru/";

    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
            city = faker.address().city(),
            phone = faker.phoneNumber().cellPhone(),
            companyName = faker.company().name(),
            textMessage = faker.lorem().paragraph(),
            email = "exmpale@net.mail";

    public Faker getFaker() {
        return faker;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getEmail() {
        return email;
    }

    public void search(String string) {
        open(Url);
        $x("//input[@name='q']").val(string).pressEnter();
        $(".search-result__title").shouldHave(text(string));
    }

}
