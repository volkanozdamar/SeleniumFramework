package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthentication {
    WebDriver driver;
    //Constructor
    public FormAuthentication(WebDriver driver){
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "username")
    WebElement mUserNameTextBox;
    @FindBy(id = "password")
    WebElement mPasswordTextBox;
    @FindBy(className = "fa-sign-in")
    WebElement mSignInButton;
    @FindBy(id = "flash")
    WebElement mLoginMessage;

    public void FillUserNameTextBox(String text){
        mUserNameTextBox.sendKeys(text);
    }
    public void FillPasswordTextBox(String text){
        mPasswordTextBox.sendKeys(text);
    }
    public void SignInButton(){
        mSignInButton.click();
    }
    public String LoginMessage(){
        return mLoginMessage.getText().trim();
    }
}
