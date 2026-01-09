package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import seleniumCore.DriverManager;
import seleniumCore.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    DriverManager driverManager;
    public WebDriver driver;

    public void init(String browser) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getDriver();
    }

    public void quit(){
        driverManager.quitDriver();
    }

    public void oppenApp(String env) throws Exception {
        env = env.toUpperCase();
        switch(env){
            case "PROD":{
                driver.get("https://www.saucedemo.com/");
                break;
            }
            default: throw new Exception("Environment: " + env + " is not supported!");
        }
    }

    public void takeScreenshot(String fileName) throws IOException {
        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("results/screenshots/" + fileName + ".png"));
    }

    public void reportScreenshot(String fileName, String desc) throws IOException {
        takeScreenshot(fileName);
        Path content = Paths.get("results/screenshots/" + fileName + ".png");
        try(InputStream is = Files.newInputStream(content)){
            io.qameta.allure.Allure.addAttachment(desc, is);
        }catch(IOException e){
            e.printStackTrace();
            e.getMessage();
        }
    }
}
