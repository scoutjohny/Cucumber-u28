package pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".login_logo")
    WebElement loginPageTitle;

    @FindBy(css = "#user-name")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement submitButton;

    @FindBy(css = ".title")
    WebElement title;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement menu;

    @FindBy(css = "h3")
    WebElement errorMessage;

    public void checkTitle(String expectedTitle){
        Assert.assertEquals(loginPageTitle.getText(), expectedTitle);
    }

    public void fillUsername(String username){
        userName.sendKeys(username);
    }

    public void fillPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickSubmitButton(){
//        driver.findElement(By.xpath("//*[@id='login-button']")).click(); RADI ISTU STVAR KAO I KOMANDA IZ REDA ISPOD!!!
        submitButton.click();
    }

    public void checkMenu(){
        Assert.assertTrue(menu.isDisplayed());
    }

    public void checkAnyTitle(String expectedTitle){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    public void checkErrorMessage (String errorMessageText){
        Assert.assertEquals(errorMessage.getText(),errorMessageText);
    }
}
