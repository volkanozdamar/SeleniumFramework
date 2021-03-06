package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Form Authentication")
    WebElement mClickToFormAuthentication;

    public void clickToFormAuthentication(){
        mClickToFormAuthentication.click();
        //hetrocuydo@ezehe.com
    }

}
