package online.contactlistapp.managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollManger {

    public static void scrollToEllemnt(WebElement webElement){
        //These code was added in order to scroll to a specific element present on the page

        JavascriptExecutor javascriptExecutor =(JavascriptExecutor) DriverManager.getInstance().getDriver();
        javascriptExecutor.executeScript("arguments[0].srollIntoView(false);", webElement);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
