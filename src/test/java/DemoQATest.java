import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.Downloads;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest {
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy ="eager";
    }
    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Nadya");
        $("#lastName").setValue("Piskunova");
        $("#userEmail").setValue("test@test.ru");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("81112223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(4);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1999");
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("kot.jpg");
        $("#currentAddress").setValue("ru");
        $(".css-1wa3eu0-placeholder").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Nadya Piskunova"),
                text("test@test.ru"),
                text("Female"),
                text("8111222334"),
                text("02 May,1999"),
                text("English"),
                text("Music"),
                text("kot.jpg"),
                text("ru"),
                text("NCR Delhi"));

    }

}
