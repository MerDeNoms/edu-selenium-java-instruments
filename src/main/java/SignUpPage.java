import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage  {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.cssSelector("input#email");
    By confirmField = By.cssSelector("input#confirm");
    By passwordField = By.cssSelector("input#password");
    By nameField = By.cssSelector("input#displayname");
    By dayField = By.cssSelector("input#day");
    By monthDropDown = By.cssSelector("select#month");
    String monthDropDownOption = "//select[@id='month']/option[text()='%s']";
    By yearField = By.cssSelector("input#year");
    String sexRadioButton = "//span[text()='%s']//..//..";
    By shareCheckbox = By.xpath("//span[text()='Я разрешаю сообщить мои регистрационные данные партнерам Spotify в целях рекламы.']");
    By registerButton = By.xpath("//button[@type='submit']");
    By errorLabel = By.xpath("//div[@aria-label = 'Значок ошибки']");
    String errorByText = "//div[@aria-label = 'Значок ошибки' and text() = '%s']";


}
