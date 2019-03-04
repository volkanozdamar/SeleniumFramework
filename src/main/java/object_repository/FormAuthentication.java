package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthentication {
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

    public void fillUserNameTextBox(String text){
        mUserNameTextBox.sendKeys(text);
    }
    public void fillPasswordTextBox(String text){
        mPasswordTextBox.sendKeys(text);
    }
    public void signInButton(){
        mSignInButton.click();
    }
    public String loginMessage(){
        return mLoginMessage.getText().trim();
    }
}
