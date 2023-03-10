package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utills.CrossBrowserSetup;

public class CrossBrowserScript {

    WebDriver driver;

    @BeforeTest
    @Parameters ("browser")
    public void startBrowser(){
        try{
           driver = new CrossBrowserSetup().setup("browser");
        } catch (Exception e){
        System.out.println(e.getMessage());
        }
    }

    @Test
    public void testParameters() throws InterruptedException {
        driver.get("http://dev.app.sportymate.rs");
        Thread.sleep(4000);
        WebElement user = driver.findElement(By.name("username"));
        user.sendKeys("petar.savic@sportymateoffical.com");
        Thread.sleep(4000);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("mFurtAZc");
        Thread.sleep(6000);
        WebElement loginBtn = driver.findElement(By.xpath("//span[@class='mat-button-wrapper']"));
        loginBtn.click();
        Thread.sleep(6000);

    }

    @AfterTest
    public void tearDown(){
       new CrossBrowserSetup().quitBrowsers(driver);
    }



}
