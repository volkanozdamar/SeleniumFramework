package TestBase;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.tinylog.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    RemoteWebDriver driver;
    Capabilities chromeCapabilities;
    Capabilities firefoxCapabilities;
    public RemoteWebDriver dockerBrowser(){
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
        driver.get(PropertiesFile.getProperties("url")) ;
        Logger.info("Browser Launched");
        return driver;
    }
}
