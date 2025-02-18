package online.contactlistapp.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("the Home Page is accessed")
    public void theHomePageIsAccessed() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @And("the Sign up button is clicked")
    public void theSignUpButtonIsClicked() {
        homePage.navigateToRegisterPage();
    }
}
