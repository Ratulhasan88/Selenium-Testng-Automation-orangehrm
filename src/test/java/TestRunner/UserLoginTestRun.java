package TestRunner;

import Pages.LoginPage;
import Setup.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.util;

import java.io.IOException;
import java.util.jar.JarEntry;

public class UserLoginTestRun extends Setup {
    @Test (priority = 1)
    public void userLogin() throws IOException, ParseException, InterruptedException {
        Thread.sleep(200);
        LoginPage loginPage= new LoginPage(driver);
        JSONArray Emplist =  util.ReadInfo();
        JSONObject Empobj = (JSONObject) Emplist.get(Emplist.size()-1);
        String username= (String) Empobj.get("userName");
        String password= (String) Empobj.get("pass");

        loginPage.Login(username, password);
    }

    public static void main(String[] args) throws IOException, ParseException {
        JSONArray Emplist =  util.ReadInfo();
        JSONObject Empobj = (JSONObject) Emplist.get(1);
        System.out.println(Empobj.get("username"));
    }

}
