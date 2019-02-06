import ExcelReader.ExcelReader;
import Screenshot.TakeScreenshot;
import Scripts.FormAuthentication;
import Scripts.MainPage;
import TestBase.TestBase;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;



public class FirstTest extends TestBase {
    RemoteWebDriver driver;
    Capabilities chromeCapabilities;
    @Link("https://example.org")
    @BeforeTest(description = "Before Chrome Test")
    public void Before_Test(){
        driver = dockerBrowser();
    }
    @Step("Type username password")
    @Test(description = "Chrome Test")
    public void FirstTest(){
        MainPage mainPage = new MainPage(driver);
        FormAuthentication formAuthentication = new FormAuthentication(driver);
        mainPage.ClickToFormAuthentication();
        Logger.info("Link is Clicked");
        TakeScreenshot.fullpageScreenshot(driver);
        formAuthentication.FillUserNameTextBox(ExcelReader.getRowData("Sheet1",1,0));
        Logger.info("USERNAME");
        formAuthentication.FillPasswordTextBox(ExcelReader.getRowData("Sheet1",1,1));
        Logger.info("Password");
        formAuthentication.SignInButton();
        TakeScreenshot.fullpageScreenshot(driver);
        Assert.assertEquals("You logged into a secure area!\n"+"×",formAuthentication.LoginMessage());
        Logger.info("Assertion Done");
    }

    @AfterTest
    public void After_Test(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }



}
