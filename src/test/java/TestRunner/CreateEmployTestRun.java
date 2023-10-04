package TestRunner;

import Pages.CreateNewEmployee;
import Pages.LoginPage;
import Setup.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.util;

import java.io.IOException;

public class CreateEmployTestRun extends Setup {
    @BeforeTest
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("Admin", "admin123");
    }

    @Test
    public void createuser() throws IOException, ParseException {
        CreateNewEmployee createNewEmployee = new CreateNewEmployee(driver);

        
        String firstName = "Ratul";
        String lastName = "Hasan";
        String userName = "Ratul87";
        String pass = "123Ratul!";
        String confirmPass = "123Ratul!";

        createNewEmployee.createuser(firstName, lastName, userName, pass, confirmPass);

        util.saveEmployInfo(firstName, lastName, userName, pass, confirmPass);
    }
}
