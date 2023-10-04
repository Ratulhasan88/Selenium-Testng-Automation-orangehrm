package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "username")
    WebElement Username;
    @FindBy(name="password")
    WebElement Pass;
    @FindBy(tagName = "Button")
    WebElement LoginBtn;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void Login(String username,String pass){
        Username.sendKeys(username);
        Pass.sendKeys(pass);
        LoginBtn.click();
    }
}
