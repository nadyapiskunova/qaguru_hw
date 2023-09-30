package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemoQAPage {
    //// selenide elements
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement titleLabel =   $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderSelect = $("[for=gender-radio-2]"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            userHobbies = $("[for=hobbies-checkbox-3]"),
            downloadImage = $("#uploadPicture"),
            userAddress = $("#currentAddress"),
            submitClick =  $("#submit");
    ///// actions
    public DemoQAPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public DemoQAPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public DemoQAPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public DemoQAPage setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public DemoQAPage setGenderSelect(){
        genderSelect.click();

        return this;
    }

    public DemoQAPage setUserNumberInput(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public DemoQAPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate("02","May", "1999");

        return this;
    }

    public DemoQAPage setSubjectsInput(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public DemoQAPage setUsersHobbies(){
        userHobbies.click();

        return this;
    }

    public DemoQAPage setImage(String value){
        downloadImage.uploadFromClasspath(value);

        return this;
    }

    public DemoQAPage setUserAddress(String value){
        userAddress.setValue(value);

        return this;
    }

    public DemoQAPage stateSelect(String state){
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        return this;
    }

    public DemoQAPage citySelect(String city){
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        return this;
    }

    public DemoQAPage setSubmitClick(){
        submitClick.click();

        return this;
    }

    public DemoQAPage checkResults(String key,String value){
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));


        return this;
    }
}
