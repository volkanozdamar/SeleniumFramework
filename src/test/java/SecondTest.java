import excelreader.ExcelReader;
import testbase.TestBase;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;

public class SecondTest extends TestBase{
    @VisibleForTesting
    private RemoteWebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = dockerBrowser();
    }
    @Test(description = "Firefox Test")
    public void myTest(){
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
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }



}
