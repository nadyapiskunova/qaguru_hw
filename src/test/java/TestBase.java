import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy ="eager";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize ="1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
