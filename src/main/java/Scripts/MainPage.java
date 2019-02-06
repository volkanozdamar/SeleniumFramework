package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Form Authentication")
    WebElement mClickToFormAuthentication;

    public void ClickToFormAuthentication(){
        mClickToFormAuthentication.click();
        //hetrocuydo@ezehe.com
    }

}
