import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignUpPage;
import steps.SignUpSteps;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class SignUpTest {

    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void typeInvalidYear() {
        steps.open_sing_up_page();
        steps.set_month("Апрель");
        steps.type_day("20");
        steps.type_year("85");
        steps.set_share(true);
        steps.should_see_error("Укажите действительный год.");
        steps.should_not_see_error("When were you born?");
    }


    @Test
    public void typeInvalidEmail() {
        steps.open_sing_up_page();
        steps.type_email("test@mail.test");
        steps.type_confirmation_mail("wrong@mail.test");
        steps.type_name("Testname");
        steps.click_sign_up();
        steps.should_see_error("Адреса электронной почты не совпадают.");
    }


    @Test
    public void signUpWithEmptyPassword() {
        steps.open_sing_up_page();
        steps.type_email("test@mail.test");
        steps.type_confirmation_mail("test@mail.test");
        steps.type_name("Testname");
        steps.click_sign_up();
        steps.should_see_error("Введите пароль.");
    }


    @Test
    public void typeInvalidValues() {
        steps.open_sing_up_page();
        steps.type_email("tesmail");
        steps.type_confirmation_mail("wrong@mail.test");
        steps.type_name("Name");
        steps.select_sex("Мужчина");
        steps.set_share(false);
        steps.click_sign_up();
        steps.should_see_errors_count(7);
        steps.should_see_error_by_num(4, "Укажите действительный день месяца.");
    }
}
