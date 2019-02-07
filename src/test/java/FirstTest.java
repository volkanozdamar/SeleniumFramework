import excelreader.ExcelReader;
import screenshot.TakeScreenshot;
import scripts.FormAuthentication;
import scripts.MainPage;
import testbase.TestBase;
import com.google.common.annotations.VisibleForTesting;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;



public class FirstTest extends TestBase {
    @VisibleForTesting
    private RemoteWebDriver driver;
    @BeforeTest(description = "Before Chrome Test")
    public void beforeTest(){
        driver = dockerBrowser();
    }
    @Step("Type username password")
    @Test(description = "Chrome Test")
    public void firstTest(){
        MainPage mainPage = new MainPage(driver);
        FormAuthentication formAuthentication = new FormAuthentication(driver);
        mainPage.clickToFormAuthentication();
        Logger.info("Link is Clicked");
        TakeScreenshot.fullpageScreenshot(driver);
        formAuthentication.fillUserNameTextBox(ExcelReader.getRowData("Sheet1",1,0));
        Logger.info("USERNAME");
        formAuthentication.fillPasswordTextBox(ExcelReader.getRowData("Sheet1",1,1));
        Logger.info("Password");
        formAuthentication.signInButton();
        TakeScreenshot.fullpageScreenshot(driver);
        Assert.assertEquals("You logged into a secure area!\n"+"×",formAuthentication.loginMessage());
        Logger.info("Assertion Done");
    }

    @AfterTest
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }



}
