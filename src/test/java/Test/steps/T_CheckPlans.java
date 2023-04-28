package Test.steps;

import Base.TestBase;
import Page.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class T_CheckPlans extends TestBase {

    HomePage homePage;

    public T_CheckPlans() throws IOException {
    }

    @And("Check the language to be english")
    public void Check_The_Language() {
        homePage = new HomePage(BrowserObject);
        homePage.changeLangToEnglish();
    }

    @When("Select the {string}")
    public void Select_Country(String countryName) {
        homePage.changeCountry(countryName);
    }

    @Then("The plans title should be {string} and {string} and {string}")
    public void Check_PlansTitle(String planOne , String planTwo , String planThree) {
        List<String> plansTitles = new ArrayList<>();
        plansTitles.add(planOne);
        plansTitles.add(planTwo);
        plansTitles.add(planThree);
        Assert.assertTrue(homePage.checkPlansName(plansTitles));
    }

    @And("The plans price should be {string} and {string} and {string}")
    public void Check_PlansPrice(String priceOne , String priceTwo , String priceThree) {
        List<String> plansPrices = new ArrayList<>();
        plansPrices.add(priceOne);
        plansPrices.add(priceTwo);
        plansPrices.add(priceThree);
        Assert.assertTrue(homePage.checkPlansPrice(plansPrices));
    }

    @Then("The plans currency should be {string}")
    public void Check_PriceCurrency(String currencyName) {
        Assert.assertTrue(homePage.checkPlansPriceCurrency(currencyName));
    }
}
