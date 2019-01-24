import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;

import java.time.LocalDate;

public class FirstTest {
    WebDriver driver;
    @BeforeTest
    public void Before_Test(){
        Logger.info("Test Started : "+LocalDate.now());
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.get( "https://the-internet.herokuapp.com/" ) ;
        Logger.info("Browser Launched");
    }
    @Test(description = "deneme description")
    public void Deneme(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Logger.info("username entered");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Logger.info("Password entered");
        driver.findElement(By.className("fa-sign-in")).click();
        Logger.info("Button Clicked");
        Assert.assertEquals("You logged into a secure area\n"+"×",driver.findElement(By.id("flash")).getText().trim());
        Logger.info("Assertion Done!");
    }

    @AfterTest
    public void After_Test(){
        driver.close();
        Logger.info("Browser Closed");
    }



}
