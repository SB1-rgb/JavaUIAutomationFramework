package online.contactlistapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) { super(driver); }

       @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id= "submit")
    private WebElement submitButton;

    public void completeRegisterForm( String email, String password){

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        System.out.println("The registration form was populated with " + email + " and password " + password);

    }
    public void clickSubmitButton(){
        submitButton.click();
    }

}
