package TestRunner;

import Pages.CreateNewEmployee;
import Pages.LoginPage;
import Setup.Setup;
import com.github.javafaker.Faker;
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
    public void createuser() throws IOException, ParseException, InterruptedException {
        CreateNewEmployee createNewEmployee = new CreateNewEmployee(driver);

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Thread.sleep(300);
        String userName = faker.name().username();
        Thread.sleep(300);
        String pass = faker.internet().password();


        createNewEmployee.createuser(firstName, lastName, userName, pass);

        util.saveEmployInfo(firstName, lastName, userName, pass);
    }
}
