import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignUpPage  {

    private By emailField = By.cssSelector("input#email");
    private By confirmField = By.cssSelector("input#confirm");
    private By passwordField = By.cssSelector("input#password");
    private By nameField = By.cssSelector("input#displayname");
    private By dayField = By.cssSelector("input#day");
    private By monthDropDown = By.cssSelector("select#month");
    private String monthDropDownOption = "//select[@id='month']/option[text()='%s']";
    private By yearField = By.cssSelector("input#year");
    private String sexRadioButton = "//span[text()='%s']//..//..";
    private By shareCheckbox = By.xpath("//span[text()='Я разрешаю сообщить мои регистрационные данные партнерам Spotify в целях рекламы.']");
    private By registerButton = By.xpath("//button[@type='submit']");
    private By errorLabel = By.xpath("//div[@aria-label = 'Значок ошибки']");
    private String errorByText = "//div[@aria-label = 'Значок ошибки' and text() = '%s']";

    public SignUpPage open() {
        Selenide.open("/");
        return this;
    }

    public SignUpPage typeEmail(String email) {
        $(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        $(confirmField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        $(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        $(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage typeDay(String day) {
        $(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month) {
        $(monthDropDown).selectOption(month);
        return this;
    }

    public SignUpPage typeYear(String year) {
        $(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        $(By.xpath(String.format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        if (!$(shareCheckbox).isSelected() == value) {
            $(shareCheckbox).click();
        }
        return this;
    }

    public void clickSignUpButton() {
        $(registerButton).click();
    }

    public ElementsCollection getErrors() {
        return $$(errorLabel);
    }

    public SelenideElement getErrorByNumber(int number) {
        return getErrors().get(number - 1);
    }

    public SelenideElement getError(String message) {
        return $(By.xpath(String.format(errorByText, message)));
    }

}
