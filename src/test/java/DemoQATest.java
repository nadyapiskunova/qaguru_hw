import org.junit.jupiter.api.Test;
import pages.DemoQAPage;

public class DemoQATest extends TestBase {
    DemoQAPage demoQAPage = new DemoQAPage();
    @Test
    void formTest() {

        demoQAPage.openPage()
                .closeBanners()
                .setFirstName("Nadya")
                .setLastName("Piskunova")
                .setUserEmail("test@test.ru")
                .setGenderSelect("Female")
                .setUserNumberInput("8111222334")
                .setDateOfBirth("02","May", "1999")
                .setSubjectsInput("English")
                .setUsersHobbies("Music")
                .setImage("kot.jpg")
                .setUserAddress("ru")
                .stateSelect("NCR")
                .citySelect("Delhi")
                .setSubmitClick();



        demoQAPage.setModalWindow()
                .setResultsTest("Student Name","Nadya Piskunova")
                .setResultsTest("Student Email","test@test.ru")
                .setResultsTest("Gender","Female")
                .setResultsTest("Mobile","8111222334")
                .setResultsTest("Date of Birth","02 May,1999")
                .setResultsTest("Subjects","English")
                .setResultsTest("Hobbies","Music")
                .setResultsTest("Picture","kot.jpg")
                .setResultsTest("Address","ru")
                .setResultsTest("State and City","NCR Delhi");


    }

    @Test
    void emptyFullNameUser (){
        demoQAPage.openPage()
                .closeBanners()
                .setFirstName("")
                .setLastName("")
                .setUserEmail("test@test.ru")
                .setGenderSelect("Female")
                .setUserNumberInput("8111222334")
                .setDateOfBirth("02","May", "1999")
                .setSubjectsInput("English")
                .setUsersHobbies("Music")
                .setImage("kot.jpg")
                .setUserAddress("ru")
                .stateSelect("NCR")
                .citySelect("Delhi")
                .setSubmitClick();

        demoQAPage.checkEmptyFullNameUser();
    }
}
