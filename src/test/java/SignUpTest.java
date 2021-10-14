import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpTest {
    private WebDriver driver;
    private SignUpPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D://QA_Auto/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.spotify.com/kg-ru/signup");
    }


    @Test
    public void typeInvalidYear() {
        page = new SignUpPage(driver);
        page.setMonth("Апрель")
                .typeDay("20")
                .typeYear("85")
                .setShare(true);
        Assert.assertTrue(page.isErrorVisible("Укажите действительный год."));
        Assert.assertFalse(page.isErrorVisible("When were you born?"));
    }


    @Test
    public void typeInvalidEmail() {
        page = new SignUpPage(driver);
        page.typeEmail("test@mail.test")
                .typeConfirmEmail("wrong@mail.test")
                .typeName("Testname")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Адреса электронной почты не совпадают."));
    }


    @Test
    public void signUpWithEmptyPassword() {
        page = new SignUpPage(driver);
        page.typeEmail("test@mail.test")
                .typeConfirmEmail("test@mail.test")
                .typeName("Testname")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Введите пароль."));
    }


    @Test
    public void typeInvalidValues() {
        page = new SignUpPage(driver);
        page.typeEmail("tesmail")
                .typeConfirmEmail("wrong@mail.test")
                .typePassword("qweqwe!123")
                .typeName("Name")
                .setSex("Мужчина")
                .setShare(false)
                .clickSignUpButton();
        Assert.assertEquals(6, page.getErrors().size());
        Assert.assertEquals("Укажите действительный день месяца.", page.getErrorByNumber(3));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
