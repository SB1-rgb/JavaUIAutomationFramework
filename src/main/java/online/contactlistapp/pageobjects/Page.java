package online.contactlistapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);//ca sa putem initializa ulterior metoda navigateToRegisterPage
    }

    @FindBy(xpath = "//button[@id='signup']")//@FindBy - adnotare
    protected WebElement sighUpButton;

    public void navigateToRegisterPage() {
        sighUpButton.click();
        System.out.println("The register option was selected");

    }

    @FindBy(xpath = "//button[@id='logout']")//@FindBy - adnotare
    protected WebElement logoutButton;

    public void navigateToHomePage() {
        logoutButton.click();
        System.out.println("The user logged out.");

    }
}
