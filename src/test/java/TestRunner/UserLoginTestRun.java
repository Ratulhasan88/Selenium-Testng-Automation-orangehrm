package TestRunner;

import Pages.CreateNewEmployee;
import Pages.LoginPage;
import Setup.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.util;

import java.io.IOException;
import java.util.List;
import java.util.jar.JarEntry;

public class UserLoginTestRun extends Setup {
    @Test(priority = 1)
    public void userLogin() throws IOException, ParseException, InterruptedException {
        Thread.sleep(800);
        LoginPage loginPage = new LoginPage(driver);
        JSONArray Emplist = util.ReadInfo();
        JSONObject Empobj = (JSONObject) Emplist.get(Emplist.size() - 1);
        String username = (String) Empobj.get("userName");
        String password = (String) Empobj.get("pass");

        loginPage.Login(username, password);
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
    }

    public static void main(String[] args) throws IOException, ParseException {
        JSONArray Emplist = util.ReadInfo();
        JSONObject Empobj = (JSONObject) Emplist.get(1);
        System.out.println(Empobj.get("username"));
    }

    @Test(priority = 2)
    public void AssertNewUserName() {
        String ActualText = driver.findElement(By.className("oxd-userdropdown-name")).getText();
        String ExpectedText = driver.findElement(By.className("oxd-userdropdown-name")).getText();
        Assert.assertTrue(ActualText.contains(ExpectedText));



    }
    }

