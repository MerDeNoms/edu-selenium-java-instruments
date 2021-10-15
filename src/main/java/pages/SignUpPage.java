package pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://www.spotify.com/kg-ru/signup")
public class SignUpPage extends PageObject {

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

    public SignUpPage typeEmail(String email) {
        find(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        find(confirmField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        find(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        find(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage typeDay(String day) {
        find(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month) {
        find(monthDropDown).click();
        find(By.xpath(String.format(monthDropDownOption, month))).waitUntilVisible();
        return this;
    }

    public SignUpPage typeYear(String year) {
        find(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        find(By.xpath(String.format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        WebElement checkbox = find(shareCheckbox);
        if (!checkbox.isSelected() == value) {
            checkbox.click();
        }
        return this;
    }

    public void clickSignUpButton() {
        find(registerButton).click();
    }

    public ListOfWebElementFacades getErrors() {
        return findAll(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return findAll(By.xpath(String.format(errorByText, message))).size() > 0
                && findAll(By.xpath(String.format(errorByText, message))).get(0).isDisplayed();
    }

}
