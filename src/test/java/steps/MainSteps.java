package steps;

import excel.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import org.testng.Reporter;
import pages.LoginPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class MainSteps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    Map<String, String> data;
    @Before
    @Description("Starting up the browser")
    public void setup() throws Exception {
        init(browser);
    }

    @After
    @Description("Closing the bropwser")
    public void tearDown(){
        if(quit.equalsIgnoreCase("Yes")){
            quit();
        }
    }

    @Given("I am on the sauce demo login page")
    public void iAmOnTheSauceDemoLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        new LoginPage(driver).fillPassword(password); //su[tinski isto kao u prethodnom koraku samo kraće
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        new LoginPage(driver).clickSubmitButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        new LoginPage(driver).checkMenu();
    }

    @And("I should be able to see products")
    public void iShouldBeAbleToSeeProducts() {
        new LoginPage(driver).checkAnyTitle("Products");
    }

    @Then("I should se the error message {string}")
    public void iShouldSeTheErrorMessage(String errorMessage) {
        new LoginPage(driver).checkErrorMessage(errorMessage);
    }

    @Given("I load test data from {string} {string} {string}")
    public void iLoadTestDataFrom(String fileName, String sheetName, String row) throws IOException {
        data = new ExcelReader().getRowData(fileName, sheetName, Integer.parseInt(row));
    }

    @When("I enter username")
    public void iEnterUsername() {
        new LoginPage(driver).fillUsername(data.get("username"));
    }

    @And("I enter password")
    public void iEnterPassword() {
        new LoginPage(driver).fillPassword(data.get("password"));
    }

    @Given("I load test data from {string} {string} for {string}")
    public void iLoadTestDataFromFor(String fileName, String sheetName, String tc_id) throws IOException {
        data = new ExcelReader().getRowDataByID(fileName, sheetName, tc_id);
    }
}
