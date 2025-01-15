package online.contactlistapp;


import online.contactlistapp.managers.DataGeneratorManager;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.AccountPage;
import online.contactlistapp.pageobjects.HomePage;
import online.contactlistapp.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;


public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeRegisterForm("Andrei", "Ioc", DataGeneratorManager.getRandomEmail(), DataGeneratorManager.getRandomPasword(10,11));
        Thread.sleep(5000);
        registerPage.clickSubmitButton();


        AccountPage accountPage = new AccountPage(driver);
        Thread.sleep(5000);
        accountPage.navigateToHomePage();

        driver.quit();


    }
}