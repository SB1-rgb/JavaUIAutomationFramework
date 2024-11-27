package online.contactlistapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id= "firstName")
    private WebElement firstNameInput;

    @FindBy(id= "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id= "submit")
    private WebElement submitButton;

    public void completeRegisterForm(String firstName, String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        System.out.println("The registration form was populated with " + email + " and password " + password);

    }
    public void clickSubmitButton(){
        submitButton.click();
    }

}
