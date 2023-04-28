package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage {
    WebDriver browserObject;
    //Element locators
    By country_Btn = By.className("country-current");
    By language_Btn = By.id("translation-btn");
    By plan_Title = By.className("plan-title");
    By plan_Price = By.className("price");
    By country_Popup_Close = By.id("country-poppup-close");
    By selected_Country = By.className("selected");

    public HomePage(WebDriver browserObject) {
        this.browserObject = browserObject;
    }

    public void changeCountry (String countryName){
        browserObject.findElement(country_Btn).click();
        WebDriverWait wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(countryName)));
        if(browserObject.findElement(selected_Country).getText().equals(countryName)){
            browserObject.findElement(country_Popup_Close).click();
        }else {
            browserObject.findElement(By.linkText(countryName)).click();
        }
        browserObject.manage().timeouts().pageLoadTimeout(1000 , TimeUnit.MILLISECONDS);
    }

    public void changeLangToEnglish (){
        WebElement changeLangBtn = browserObject.findElement(language_Btn);
        if(changeLangBtn.getText()
                .replaceAll("\\s", "")
                .replaceAll("\n", "")
                .replaceAll("\r", "").equals("English")){
            changeLangBtn.click();
            WebDriverWait wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(language_Btn));
        }
    }
    public boolean checkPlansName (List<String> expectedPlansTitle){
        boolean isSame = true;
        List<WebElement> plansTitleLocator =  browserObject.findElements(plan_Title);
        for (int i = 0 ; i < plansTitleLocator.size() ; i++){
            if(!expectedPlansTitle.get(i).equals(plansTitleLocator.get(i).getText())){
                isSame = false;
            }
        }
        return  isSame;
    }
    public List<String> getPlansPrice (){
        List<WebElement> plansPriceLocator = browserObject.findElements(plan_Price);
        List<String> plansPriceText = new ArrayList<>();
        for (int i = 0 ; i < plansPriceLocator.size() ; i++){
            plansPriceText.add(plansPriceLocator.get(i).getText());
        }
        return  plansPriceText ;
    }

    public boolean checkPlansPrice (List<String> expectedPlansPrice){
        boolean isSame = true;
        List<String> plansPrice = new ArrayList<>();
        plansPrice = this.getPlansPrice();
        for (int i=0; i< plansPrice.size() ; i++){
            String priceCurrency[] = plansPrice.get(i).split(" ");
            if(!expectedPlansPrice.get(i).equals(priceCurrency[0])){
                isSame = false;
            }
        }
        return  isSame ;
    }

    public boolean checkPlansPriceCurrency(String currencyName){
        boolean isSameCurrency = true;
        List<String> plansPrice = new ArrayList<>();
        plansPrice = this.getPlansPrice();
        for (int i=0; i< plansPrice.size() ; i++){
            String priceCurrency[] = plansPrice.get(i).split(" ");
            if (!priceCurrency[1].contains(currencyName)){
                isSameCurrency = false;
            }
        }
        return isSameCurrency;
    }
}
