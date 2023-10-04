package TestRunner;

import Pages.LoginPage;
import Setup.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRun extends Setup {
    @Test(priority = 2)
    public void Login(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.Login("Admin","admin123");
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
    }
    @Test (priority = 1)
    public void LoginWithWrongCreds(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.Login("Admin","Admin123");
       String ActualText= driver.findElement(By.className("oxd-alert-content-text")).getText();
       String ExpectedText ="Invalid credentials";
       Assert.assertTrue(ActualText.contains(ExpectedText));

    }
}
