package online.contactlistapp;


import online.contactlistapp.managers.DataGeneratorManager;
import online.contactlistapp.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.sql.SQLOutput;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");

        WebElement sighUpButton = driver.findElement(By.xpath("//button[@id='signup']"));
        sighUpButton.click();

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        String firstName = DataGeneratorManager.getName();
        firstNameInput.sendKeys(firstName);
        System.out.println("First name is " + firstName);

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        String lastName = DataGeneratorManager.getLastName();
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.id("email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("The email used is " + emailData) ;

        WebElement passwordInput = driver.findElement(By.id("password"));
        String randomPasword = DataGeneratorManager.getRandomPasword(10,15);
        passwordInput. sendKeys(randomPasword);
        System.out.println("password is " + randomPasword);

        Thread.sleep(5000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(5000);
        System.out.println("The current URL is  " + driver.getCurrentUrl());
        System.out.println("The current page name is "  + driver.getTitle());
        System.out.println("The current URL is  " + driver.getCurrentUrl());

        driver.close();



        driver.switchTo().window(currentTabName);
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
        Thread.sleep(5000);
        driver.quit();

        System.out.println("The test is fineshed!");

    }
}