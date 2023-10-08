package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultsComponent;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemoQAPage {
    //// selenide elements
    CalendarComponent calendar = new CalendarComponent();
    CheckResultsComponent checkResult = new CheckResultsComponent();
    SelenideElement titleLabel =   $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            downloadImage = $("#uploadPicture"),
            userAddress = $("#currentAddress"),
            submitClick =  $("#submit");
    ///// actions
    public DemoQAPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));

        return this;
    }
    public DemoQAPage closeBanners(){
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

    public DemoQAPage setGenderSelect(String gender){
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public DemoQAPage setUserNumberInput(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public DemoQAPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public DemoQAPage setSubjectsInput(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public DemoQAPage setUsersHobbies(String hobby){
        $("#hobbiesWrapper").$(byText(hobby)).click();

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
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }

    public DemoQAPage citySelect(String city){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public DemoQAPage setSubmitClick(){
        submitClick.click();

        return this;
    }

    public DemoQAPage setModalWindow(){
        checkResult.openModalWindow();
        return this;
    }

    public DemoQAPage setResultsTest(String key,String value){
        checkResult.setCheckResult(key,value);

        return this;
    }

    public DemoQAPage checkEmptyFullNameUser(){
        checkResult.emptyName();

        return this;
    }
}
