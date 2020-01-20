package com.akshat.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class temp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/akshat/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com");
        driver.manage().window().maximize();
        driver.findElement(By.className("fltSwitchOpt")).findElement(By.id("oneway")).click();

        WebElement srcBox = driver.findElement(By.id("gosuggest_inputSrc"));
        Actions srcBuilder = new Actions(driver);
        Action srcSeriesOfActions = srcBuilder
                .moveToElement(srcBox)
                .click()
                .sendKeys("Lucknow (LKO)")
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build();
        srcSeriesOfActions.perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.findElement(By.xpath("//ul[contains(@class,\"autoSuggestBoxList\")]//li[1]")).click();

        WebElement dstBox = driver.findElement(By.id("gosuggest_inputDest"));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(dstBox)
                .click()
                .sendKeys("Bangalore (BLR)")
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build();
        seriesOfActions.perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("departureCalendar")).click();
    }
}
