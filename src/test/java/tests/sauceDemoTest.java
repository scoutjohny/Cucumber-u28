package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class sauceDemoTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(sauceDemoTest.class);

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception {
        init(browser);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if(quit.equalsIgnoreCase("Yes")){
            quit();
        }
    }

    @Test
    @Parameters({"env"})
    public void successfullLogin(String env) throws Exception {
        oppenApp(env);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkTitle("Swag Labs"); //1
        loginPage.fillUsername("standard_user"); //2
        loginPage.fillPassword("secret_sauce"); //3
        loginPage.clickSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
