package online.contactlistapp;


import online.contactlistapp.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://msign.gov.md/#/");
        Thread.sleep(5000);
        driver.close();



        driver.switchTo().window(currentTabName);
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");
        Thread.sleep(5000);
        driver.quit();

        System.out.println("The test is fineshed!");

    }
}