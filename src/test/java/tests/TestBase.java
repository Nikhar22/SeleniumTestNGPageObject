package tests;

import base.DriverBase;
import businesslogic.BasePage;
import config.CommonActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase extends DriverBase {
CommonActions commonActions;
BasePage basePage;

    @BeforeMethod
    public void initDriver() throws IOException {
        driver = initializeDriver();
        commonActions = new CommonActions(driver);
        basePage = new BasePage(driver);
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();;
    }
    @AfterSuite
    public void tearDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
