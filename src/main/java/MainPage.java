import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    //Constructor
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
