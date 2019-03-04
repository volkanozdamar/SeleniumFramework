package tabs;

import org.openqa.selenium.WebDriver;
import org.tinylog.Logger;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class Tabs {
    WebDriver driver;
    Set<String> browserTabs;
    String browserTab;
    Iterator iterator;
    AtomicInteger atomicInteger ;

    public Tabs(WebDriver driver) {
        this.driver = driver;
        browserTabs = driver.getWindowHandles();
        browserTab = driver.getWindowHandle();
    }
    public long getTabCount(){
        return browserTabs.stream().count();
    }
    public void listOpenBrowserTabs(){
        atomicInteger = new AtomicInteger(1);
        browserTabs.stream().map(i -> atomicInteger.getAndIncrement()+" "+i).forEach(Logger::info);
    }

    public String getBrowserTab() {
        return browserTab;
    }

    public String nthTab(int nth){
        int counter = 0;
        String element="";
        iterator = browserTabs.iterator();
        while( nth != counter && iterator.hasNext())
        {
            element = (String) iterator.next();
            counter++;
        }
        return element;
    }

    public void firstTab(){
        if(!browserTabs.isEmpty()) {
            String firstWindow = browserTabs.iterator().next();
            driver.switchTo().window(firstWindow);
            Logger.info("First Tab is : "+driver.getWindowHandle());
        }
    }
}
