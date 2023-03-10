package utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CrossBrowserSetup {

    WebDriver driver;


    public WebDriver setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/macmini/Desktop/Todor/Practice/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/macmini/Desktop/Todor/Practice/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.chrome.driver", "/Users/macmini/Desktop/Todor/Practice/msedgedriver");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            return driver;
        } else {
            throw new Exception("Browser is not correct");
        }
    }

    public void quitBrowsers(WebDriver driver) {
        driver.quit();
        System.out.println("Driver closed");
    }
}
