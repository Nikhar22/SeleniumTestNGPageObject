package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class CommonActions {
    public WebDriver driver;
    WebDriverWait wait;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);

    }

    public void waitForVisibilityOfElement(WebElement id) {
        wait.until(ExpectedConditions.visibilityOf(id));
    }
    public void jsClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void selectVisibleTextFromDropDown(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
    }

    public void waitForPageToLoad(WebDriver driver, int timeout) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }


    public void moveToElementAndCLick(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element);
        act.click().build().perform();
    }
    public void scrollToElement(WebElement element){
        Actions act = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void moveToElement(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element);
        act.build().perform();
    }

    public boolean isElementVisible(WebElement element) {
        try {
            this.waitForVisibilityOfElement(element);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
