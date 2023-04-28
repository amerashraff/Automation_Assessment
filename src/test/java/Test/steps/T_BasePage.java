package Test.steps;

import Base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class T_BasePage extends TestBase {

    public T_BasePage() throws IOException {
    }

    @Given("Open the browser and navigate to stcTV site")
    @BeforeSuite
    public void Open_Browser_And_Navigate_to_demoblaze_Site() {
        OpeningBroswer("chrome");
    }
    @And("Close the browser")
    @AfterSuite
    public void CloseBrowser() {
        closeDriver();
    }

}
