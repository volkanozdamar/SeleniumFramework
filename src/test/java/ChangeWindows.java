import com.google.common.annotations.VisibleForTesting;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;
import testbase.TestBase;
import tabs.Tabs;

public class ChangeWindows extends TestBase {
    @VisibleForTesting
    private RemoteWebDriver driver;
    @BeforeTest(description = "Before Chrome Test")
    public void beforeTest(){
        driver = dockerBrowser("http://guidebook.seleniumacademy.com/Window.html");
    }
    @Step("Type username password")
    @Test(description = "Chrome Test")
    public void firstTest(){
        WebElement link = driver .findElement(By. linkText ( "Google Search" )) ;
        link.click() ;
        new Tabs(driver).listOpenBrowserTabs();
        System.out.println(driver.getTitle());
        new Tabs(driver).firstTab();
        System.out.println("2nd tab is "+new Tabs(driver).nthTab(2));
        System.out.println("1st tab is "+new Tabs(driver).nthTab(1));

    }

    @AfterTest
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }



}

