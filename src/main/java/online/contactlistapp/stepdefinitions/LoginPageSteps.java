package online.contactlistapp.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("the Login page is populated with following values:")
    public void theLoginPageIsPopulatedWithFollowingValues(List<String> collectedlist) {
        String email = collectedlist.get(0);
        String password = collectedlist.get(1);
        loginPage.completeRegisterForm(email, password);

    }

    @When("the login button is clicked")
    public void theLoginButtonIsClicked() {
        loginPage.clickSubmitButton();
        System.out.println("The login button was clicked");
    }
}
