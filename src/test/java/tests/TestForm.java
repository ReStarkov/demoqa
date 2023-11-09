package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm extends BaseTest {

    //самая первая версия теста

    String phone = "7926467397";
    String name = "Roman";
    String lastName = "Starkov";
    String email = "123@gmail.com";
    String date = "24 Oct 1987";
    String address = "Selo kukuevo";
    String state = "Uttar Pradesh";
    String city = "Agra";
    List<String> subjects = List.of("Maths", "English");

    private SelenideElement firstNameLocator = $("#firstName");
    private SelenideElement lastNameLocator = $("#lastName");
    private SelenideElement userEmailLocator = $("#userEmail");
    private SelenideElement genderMaleLocator = $(byText("Male"));
    private SelenideElement userNumberLocator = $("#userNumber");
    private SelenideElement dateOfBirthLocator = $("#dateOfBirthInput");
    private SelenideElement subjectsContainerLocator = $("#subjectsInput");
    private SelenideElement hobiesLocator = $(byText("Sports"));
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement uploadPicture =  $("#uploadPicture");
    private SelenideElement stateLocator =  $("#state");
    private SelenideElement cityLocator =  $("#city");
    private SelenideElement choseStateLocator = $("#react-select-3-option-1");
    private SelenideElement choseCityLocator = $("#react-select-4-option-0");
    private SelenideElement submit = $("#submit");
    private SelenideElement finalWindow = $(".table-responsive");

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        firstNameLocator.setValue(name);
        lastNameLocator.setValue(lastName);
        genderMaleLocator.click();
        userNumberLocator.setValue(phone);
        userEmailLocator.setValue(email);
        dateOfBirthLocator.setValue(date).pressEnter();
        subjectsContainerLocator.setValue(subjects.get(0)).pressEnter().setValue(subjects.get(1)).pressEnter();
        hobiesLocator.click();
        uploadPicture.uploadFromClasspath("pictures/3.jpg");
        currentAddress.setValue(address);
        stateLocator.click();
        choseStateLocator.click();
        cityLocator.click();
        choseCityLocator.click();
        submit.click();

        finalWindow.shouldHave(text(name), text(lastName),
                text(email), text(phone), text(address),text(state),text(city));

    }
}
