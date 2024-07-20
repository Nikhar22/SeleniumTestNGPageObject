package utils;

import base.DriverBase;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Utils extends DriverBase {

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        String destination = System.getProperty("user.dir") + "/reports/failed/" + testCaseName + "_"
                + ThreadLocalRandom.current().nextInt() + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
    public String getScreenshotForPassed(String testCaseName, WebDriver driver) throws IOException {
        String destination = System.getProperty("user.dir") + "/reports/passed/" + testCaseName + "_"
                + ThreadLocalRandom.current().nextInt() + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
}
