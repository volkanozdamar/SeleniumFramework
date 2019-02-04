import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class SecondTest {
    RemoteWebDriver driver;
    Capabilities firefoxCapabilities;
    @BeforeTest
    public void Before_Test(){
        Logger.info("Test Started : ");
        try {
            firefoxCapabilities = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);
        } catch(MalformedURLException e) {
            Logger.error("Error"+e);
        }
        driver.get( "https://the-internet.herokuapp.com/" ) ;
        Logger.info("Browser Launched");
    }
    @Test(description = "Firefox Test")
    public void Deneme(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Logger.info("username entered");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Logger.info("Password entered");
        driver.findElement(By.className("fa-sign-in")).click();
        Logger.info("Button Clicked");
        Assert.assertEquals("You logged into a secure area!\n"+"×",driver.findElement(By.id("flash")).getText().trim());
        Logger.info("Assertion Done!");
    }

    @AfterTest
    public void After_Test(){
        driver.quit();
        Logger.info("Browser Closed");
    }



}
