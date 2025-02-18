package online.contactlistapp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
     features = "src/main/java/online/contactlistapp/features",//locatia la feature files
     glue ="online.contactlistapp.stepdefinitions",  //implementarea pasilor tehnici
        tags = " ",
        plugin = {"pretty", "html: target/cucumber-reports"}// plugin pentru generare de rapoarte care se numeste pretty, se stocheaza in html

)


public class CucumberTestRunner {


}
