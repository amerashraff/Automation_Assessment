package Base;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    //drivers and you can set any browser you want
    public static WebDriver BrowserObject;

    //Basic Properties file that contain basic info [~ENV]
    public static Properties proFile;

    // This function for declare the config Properties
    public TestBase() throws IOException {
        String proFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties" ;
        proFile = new Properties();
        FileInputStream input = new FileInputStream(proFilePath);
        proFile.load(input);
    }

    //Opening Browser Function
    public void OpeningBroswer(@Optional("Edge") String browserName) {
        switch (browserName) {
            case "firefox":
                FirefoxOptions fireFoxOptions = new FirefoxOptions();
                fireFoxOptions.addArguments("--remote-allow-origins=*");
                BrowserObject = new FirefoxDriver(fireFoxOptions);
                break;
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                BrowserObject = new ChromeDriver(chromeOptions);
        }
        String URL = proFile.getProperty("URL");
        BrowserObject.navigate().to(URL);
        BrowserObject.manage().window().maximize();
    }

    //for close the browser
    public void closeDriver() {
        //Close Browser
        BrowserObject.quit();
    }

    public boolean isDisplayed(By elementLocator) {
        return BrowserObject.findElement(elementLocator).isDisplayed();
    }

    //Navigate to specific URL
    /*public void Navigate_With_Parameter (String parameter) {
        String URL = proFile.getProperty("URL");                    // no need in this task
        BrowserObject.navigate().to(URL + parameter);
    }*/

    /*public void ScrollUpAndDown (String upORdown){   // no need in this task
        JavascriptExecutor jsExecute = (JavascriptExecutor) BrowserObject;
        switch(upORdown) {
            case "up":
                jsExecute.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
                break;
            case "down":
            default:
                jsExecute.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
    }*/
}
