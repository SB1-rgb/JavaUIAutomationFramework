package online.contactlistapp.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import online.contactlistapp.managers.DataGeneratorManager;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the registration form is populated valid data")
    public void theRegistrationFormIsPopulatedValidData() {

        String name = DataGeneratorManager.getRandomFirstName();
        String lastName = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPasword(10, 20);

        registerPage.completeRegisterForm(name, lastName, email, password);

    }


    @When("the Submit button is clicked")
    public void theSubmitButtonIsClicked() {
        registerPage.clickSubmitButton();
    }

    @Then("user remains on the Register page")
    public void userRemainsOnTheRegisterPage() {
        driver.getCurrentUrl();
        System.out.println("User remained on Register page " + driver.getCurrentUrl());
    }


    @And("the register form is populated with following data:")
    public void theRegisterFormIsPopulatedWithFollowingData(Map<String, String> userDetailsMap) {
        String firstNameValue = userDetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataGeneratorManager.getRandomFirstName();
        }

        String lastNameValue = userDetailsMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = DataGeneratorManager.getRandomLastName();
        }

        String emailvalue = userDetailsMap.get("email");
        if (emailvalue != null && emailvalue.toUpperCase().equals("RANDOM")) {
            emailvalue = DataGeneratorManager.getRandomEmail();
        }

        String passwordValue = userDetailsMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = DataGeneratorManager.getRandomPasword(7, 15);
        }

        registerPage.completeRegisterForm(firstNameValue, lastNameValue, emailvalue, passwordValue);


    }
}
