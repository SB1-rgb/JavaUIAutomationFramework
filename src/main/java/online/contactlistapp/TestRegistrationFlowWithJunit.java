package online.contactlistapp;

import online.contactlistapp.managers.DataGeneratorManager;
import online.contactlistapp.managers.DriverManager;
import online.contactlistapp.pageobjects.AccountPage;
import online.contactlistapp.pageobjects.HomePage;
import online.contactlistapp.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

   static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void executeBeforeAllTests(){
        System.out.println("The test suit is started");
    }


   @BeforeEach
   public void executeBeforeEachTest(){
       driver = DriverManager.getInstance().getDriver();
       driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
       homePage = new HomePage(driver);
       homePage.navigateToRegisterPage();
       registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("New user is registered on contactlistapp with valid credentials")

    public void registerWithValidData() throws InterruptedException {

        String email = DataGeneratorManager.getRandomEmail();
        String firstName = DataGeneratorManager.getName();
        String lastName = DataGeneratorManager.getLastName();
        String password = DataGeneratorManager.getRandomPasword(10, 25);
        System.out.println("The Email used is " + email + " " + " and the password used is " + password);
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.clickSubmitButton();

        Thread.sleep(500);

        AccountPage accountPage = new AccountPage(driver);
        Assertions.assertTrue(accountPage.isLogoutButtonDisplayed(), "The logout button is displayed");

    }
    @Test
    @DisplayName("User can't register on contactlistapp with invalid password")

    public void cantRegisterWithInvalidData() throws InterruptedException {

        String email = DataGeneratorManager.getRandomEmail();
        String firstName = DataGeneratorManager.getName();
        String lastName = DataGeneratorManager.getLastName();
        String password = DataGeneratorManager.getRandomPasword(1, 2);
        System.out.println("The Email used is " + email + " " + " and the password used is " + password);
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.clickSubmitButton();

        Thread.sleep(500);

        AccountPage accountPage = new AccountPage(driver);
        Assertions.assertTrue(accountPage.isLogoutButtonDisplayed(), "The logout button is displayed");

    }
    @AfterEach
    public void executeAfterEachTestRun(){
        driver.quit();
    }

    @AfterAll
    public static void executeAfterAllSuiteTests(){
        System.out.println("The test suite has been executed");
    }
}
