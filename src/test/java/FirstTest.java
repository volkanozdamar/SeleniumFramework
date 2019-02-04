import io.qameta.allure.Link;
import io.qameta.allure.Step;
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


public class FirstTest  {
    RemoteWebDriver driver;
    Capabilities chromeCapabilities;
    @Link("https://example.org")
    @BeforeTest(description = "Before Chrome Test")
    public void Before_Test(){
        String browserProp = PropertiesFile.getProperties("browser");
        Logger.info("Test Started with : "+browserProp+" browser");
        if (browserProp.equalsIgnoreCase("chrome")){
        try {
            chromeCapabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
        } catch(MalformedURLException e) {
            Logger.trace(e);
            Logger.error("Error"+e);
        }
        }
        driver.get(PropertiesFile.getProperties("url")) ;
        Logger.info("Browser Launched");
    }
    @Step("Type username password")
    @Test(description = "Chrome Test")
    public void Deneme(){
        MainPage mainPage = new MainPage(driver);
        FormAuthentication formAuthentication = new FormAuthentication(driver);
        mainPage.ClickToFormAuthentication();
        Logger.info("Link is Clicked");
        formAuthentication.FillUserNameTextBox(ExcelReader.getRowData("Sheet1",1,0));
        Logger.info("USERNAME");
        formAuthentication.FillPasswordTextBox(ExcelReader.getRowData("Sheet1",1,1));
        Logger.info("Password");
        formAuthentication.SignInButton();
        Assert.assertEquals("You logged into a secure area!\n"+"×",formAuthentication.LoginMessage());
        Logger.info("Assertion Done");
    }

    @AfterTest
    public void After_Test(){
        driver.close();
        driver.quit();
        Logger.info("Browser Closed");
    }



}
