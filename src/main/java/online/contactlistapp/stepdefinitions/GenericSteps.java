package online.contactlistapp.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import online.contactlistapp.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();


    @Given("The {string} link is accessed")
    public void theLinkIsAccessed(String collectedLink) {
        driver.get(collectedLink);
        System.out.println("The link " + collectedLink + " is accessed");
    }

    @Then("the following error message is displayed")
    public void theFollowingErrorMessageIsDisplayed(List<String> errorsList) throws InterruptedException {
        Thread.sleep(1500);
        errorsList.forEach(errorMessage -> {
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath(" .//*[contains(text(),'" + errorMessage + "')] ")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed, "Message is displayed");
        });

    }

    @When("{string} from {string} is clicked")
    public void fromIsClicked(String clickableElement, String pageName) throws ClassNotFoundException, NoSuchFieldException {
        Class classInstance = Class.forName("online.contactlistapp.pageobjects." + pageName);
        Field webClickableElementField = classInstance.getDeclaredField(clickableElement);
        webClickableElementField.setAccessible(true);
        

    }
}
