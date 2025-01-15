package online.contactlistapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isLogoutButtonDisplayed(){
        return logoutButton.isDisplayed();
    }

}

