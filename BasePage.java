package Pages;


import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds (10));
    }

    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    public void click (By elementBy){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    public void writeText (By elementBy, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);        
    }

    public String readText (By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertStringEquals (String expectedString, String acctualText){
        assertStringEquals (expectedString, acctualText);
    }

    public void assertIntigerEquals (int expectedNumber, int actualNumber){
        assertEquals(expectedNumber, actualNumber);
    }

    public int countItems(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy).size();   
    }

    public String readHref (By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute("href");
    }    
        
    }


