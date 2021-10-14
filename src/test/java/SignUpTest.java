import com.codeborne.selenide.Condition;
import org.junit.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;

public class SignUpTest {
    private SignUpPage page;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D://QA_Auto/chromedriver_win32/chromedriver.exe");
        baseUrl = "https://www.spotify.com/kg-ru/signup";
    }


    @Test
    public void typeInvalidYear() {
        page = new SignUpPage();
        page.open()
                .setMonth("Апрель")
                .typeDay("20")
                .typeYear("85")
                .setShare(true);
        page.getError("Укажите действительный год.").shouldBe(Condition.visible);
        page.getError("When were you born?").shouldNotBe(Condition.visible);
    }


    @Test
    public void typeInvalidEmail() {
        page = new SignUpPage();
        page.open()
                .typeEmail("test@mail.test")
                .typeConfirmEmail("wrong@mail.test")
                .typeName("Testname")
                .clickSignUpButton();
        page.getError("Адреса электронной почты не совпадают.").shouldBe(Condition.visible);
    }


    @Test
    public void signUpWithEmptyPassword() {
        page = new SignUpPage();
        page.open()
                .typeEmail("test@mail.test")
                .typeConfirmEmail("test@mail.test")
                .typeName("Testname")
                .clickSignUpButton();
        page.getError("Введите пароль.").shouldBe(Condition.visible);
    }


    @Test
    public void typeInvalidValues() {
        page = new SignUpPage();
        page.open()
                .typeEmail("tesmail")
                .typeConfirmEmail("wrong@mail.test")
                .typePassword("qweqwe!123")
                .typeName("Name")
                .setSex("Мужчина")
                .setShare(false)
                .clickSignUpButton();
        page.getErrors().shouldHave(size(6));
        page.getErrorByNumber(3).shouldHave(text("Укажите действительный день месяца."));
    }

}
