package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CreateNewEmployee {
    @FindBy(className = "oxd-main-menu-item--name")
    List<WebElement> Menue ;

    @FindBy(className = "oxd-button--secondary")
    List<WebElement> AddBtn ;

    @FindBy(className = "oxd-switch-input--active")
    List<WebElement> CreateLoginDetails;
    @FindBy(className = "oxd-input")
    List<WebElement> EmployeeTextFields;

    @FindBy(className = "oxd-button")
    List<WebElement> SaveBtn;

    @FindBy(className = "oxd-userdropdown-name")
    WebElement name;

    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement>  Logout;



    public CreateNewEmployee(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    public void createuser(String firstName, String lastName, String userName, String pass) throws InterruptedException {
        Menue.get(1).click();
        AddBtn.get(1).click();

        EmployeeTextFields.get(1).sendKeys(firstName);
        EmployeeTextFields.get(3).sendKeys(lastName);
        CreateLoginDetails.get(0).click();
        EmployeeTextFields.get(5).sendKeys(userName);
        EmployeeTextFields.get(6).sendKeys(pass);
        EmployeeTextFields.get(7).sendKeys(pass);
        SaveBtn.get(1).click();
        Thread.sleep(1800);

        name.click();
        Thread.sleep(1200);
        Logout.get(3).click();












    }
}
