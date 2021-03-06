package testpackage.steps.jbehave;

import net.thucydides.core.annotations.Steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import testpackage.steps.serenity.SignUpSteps;

public class SignUpPageSteps {

    @Steps
    SignUpSteps steps;

    @Given("I open sign up page")
    public void openPage() {
        steps.open_sign_up_page();
    }

    @When("I set month \"$month\"")
    public void setMonth(String month) {
        steps.set_month(month);
    }

    @When("I set day \"$day\"")
    public void typeDay(String day) {
        steps.type_day(day);
    }

    @When("I set year \"$year\"")
    public void typeYear(String year) {
        steps.type_year(year);
    }

    @When("I check share")
    public void checkShare() {
        steps.set_share(true);
    }

    @When("I uncheck share")
    public void uncheckShare() {
        steps.set_share(false);
    }

    @When("I type email \"$email\"")
    public void typeEmail(String email) {
        steps.type_email(email);
    }

    @When("I type confirmartion email \"$email\"")
    public void typeConfirmationEmail(String email) {
        steps.type_confirmation_mail(email);
    }

    @When("I type name \"$name\"")
    public void typeName(String name) {
        steps.type_name(name);
    }

    @When("I select sex \"$sex\"")
    public void selectSex(String sex) {
        steps.select_sex(sex);
    }

    @When("I click signup")
    public void clickSignUp() {
        steps.click_sign_up();
    }

    @Then("I see error \"$message\"")
    public void shouldSeeErrorByText(String text) {
        steps.should_see_error(text);
    }

    @Then("I do not see error \"$message\"")
    public void shouldNotSeeErrorByText(String text) {
        steps.should_not_see_error(text);
    }


    @Then("I see \"$number\" errors")
    public void shouldSeeNumberOfErrors(int number) {
        steps.should_see_errors_count(number);
    }


    @Then("I see that error \"$number\" has text \"$message")
    public void shouldSeeErrorByNumber(int number, String message) {
        steps.should_see_error_by_num(number, message);
    }

}
