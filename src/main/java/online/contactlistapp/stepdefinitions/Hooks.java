package online.contactlistapp.stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import online.contactlistapp.managers.DriverManager;

public class Hooks {

    @BeforeAll
    public static void executeBeforeAllTests(){
        System.out.println("Started!!!");
    }

    @Before
    public void executeBeforeEachTest(){
        System.out.println("This will be executed before each and every test!");

    }


    @After
    public void executeAfterEachTest(){
        DriverManager.getInstance().quitTheDriver();
    }


    @AfterAll
    public static void executeAfterAllTests(){
        System.out.println("all tests are executed!");
    }




}
