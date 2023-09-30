import org.junit.jupiter.api.Test;
import pages.DemoQAPage;

public class DemoQATest extends TestBase {
    DemoQAPage demoQAPage = new DemoQAPage();
    @Test
    void formTest() {

        demoQAPage.openPage()
                .setFirstName("Nadya")
                .setLastName("Piskunova")
                .setUserEmail("test@test.ru")
                .setGenderSelect()
                .setUserNumberInput("8111222334")
                .setDateOfBirth("02","May", "1999")
                .setSubjectsInput("English")
                .setUsersHobbies()
                .setImage("kot.jpg")
                .setUserAddress("ru")
                .stateSelect("NCR")
                .citySelect("Delhi")
                .setSubmitClick();


        demoQAPage.checkResults("Student Name","Nadya Piskunova")
                .checkResults("Student Email","test@test.ru")
                .checkResults("Gender","Female")
                .checkResults("Mobile","8111222334")
                .checkResults("Date of Birth","02 May,1999")
                .checkResults("Subjects","English")
                .checkResults("Hobbies","Music")
                .checkResults("Picture","kot.jpg")
                .checkResults("Address","ru")
                .checkResults("State and City","NCR Delhi");


    }

    @Test
    void emptyNameUser (){
        demoQAPage.openPage()
                .setFirstName("")
                .setLastName("")
                .setUserEmail("test@test.ru")
                .setGenderSelect()
                .setUserNumberInput("8111222334")
                .setDateOfBirth("02","May", "1999")
                .setSubjectsInput("English")
                .setUsersHobbies()
                .setImage("kot.jpg")
                .setUserAddress("ru")
                .stateSelect("NCR")
                .citySelect("Delhi")
                .setSubmitClick();
    }
}
