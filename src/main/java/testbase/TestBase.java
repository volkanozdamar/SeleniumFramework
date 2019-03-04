package testbase;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.tinylog.Logger;

import java.net.MalformedURLException;
import java.net.URL;

import static testbase.PropertiesFile.browser;

public class TestBase {
    RemoteWebDriver driver;
    @VisibleForTesting
    private Capabilities chromeCapabilities;
    @VisibleForTesting
    private Capabilities firefoxCapabilities;
    /**
     *
     * Reads the capabilities from properties file
     *
     * @return
     */
    public RemoteWebDriver dockerBrowser(){
        browseWithDocker();
        driver.get(PropertiesFile.getProperties("url")) ;
        Logger.info("Browser Launched");
        return driver;
    }

    /**
     *
     * Take url to navigate from docker
     *
     * @param mUrl
     * @return
     */


    public RemoteWebDriver dockerBrowser(String mUrl){
        browseWithDocker();
        driver.get(mUrl) ;
        Logger.info("Browser Launched with : "+mUrl);
        return driver;
    }

    public WebDriver runLocal(){
        String browserProp = PropertiesFile.getProperties("browser");
        Logger.info("Test Started with : "+browserProp+" browser");
        if(browserProp.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/resources/mac/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/resources/mac/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(PropertiesFile.getProperties("url")) ;
        Logger.info("Browser Launched");
        return driver;
    }

    /**
     * Eliminate Code Redundancy
     */
    private void browseWithDocker() {
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
        else if(browserProp.equalsIgnoreCase("firefox")){
            try {
                firefoxCapabilities = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);
            } catch(MalformedURLException e) {
                Logger.trace(e);
                Logger.error("Error"+e);
            }
        }
    }
}
