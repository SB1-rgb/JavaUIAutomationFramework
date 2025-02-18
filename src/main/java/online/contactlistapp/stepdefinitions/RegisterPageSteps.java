package online.contactlistapp.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import online.contactlistapp.managers.DataGeneratorManager;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the registration form is populated valid data")
    public void theRegistrationFormIsPopulatedValidData() {

        String name = DataGeneratorManager.getName();
        String lastName = DataGeneratorManager.getLastName();
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
}
