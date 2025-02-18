package online.contactlistapp.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.AccountPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {
    WebDriver driver= DriverManager.getInstance().getDriver();


    @Then("user is successful registrated")
    public void userIsSuccessfulRegistrated() {

    }

    @And("user is redirected to Account Page")
    public void userIsRedirectedToAccountPage() throws InterruptedException {

        boolean theUrlContainsExpectedValue = (driver.getCurrentUrl().contains("addUser"));
        System.out.println("Current URL on AccountPage is " + driver.getCurrentUrl());
        Assertions.assertTrue(theUrlContainsExpectedValue, "the expected value is dispalyed in the url");

        Thread.sleep(1000);


    }
}
