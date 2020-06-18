package com.akshat.miqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoibiboDemo
{
    public static void main(String[] args)
    {
        // path to chromedriver
        System.setProperty("webdriver.chrome.driver", "/home/akshat/Downloads/chromedriver");

        // create a chrome driver and direct it to goibibo site with full screen window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com");

        // select one way flight option
        driver.findElement(By.id("oneway")).click();

        // insert src address
        driver.findElement(By.id("gosuggest_inputSrc")).click();
        driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Delhi");
        // wait for 5 sec for the react autosuggest box to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ENTER);

        // wait for src address react box to get selected before inserting destination address
        // give some time diff between implicit time of previous wait and new wait
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // insert destination address
        driver.findElement(By.id("gosuggest_inputDest")).click();
        driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Bangalore");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ENTER);

        // wait for destination react entry to complete
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        // select today's date for departure
        driver.findElement(By.id("departureCalendar")).click();
        driver.findElement(By.xpath("//*[contains(@class,'DayPicker-Day DayPicker-Day--today')]")).click();

        // press search button
        driver.findElement(By.xpath("//*[contains(@class,'fb button orange large ht55 fltHpySrchBtn')]")).click();

        // if next page search button is displayed test is successful
        boolean result = driver.findElement(By.id("submitSearchButton_srp")).isDisplayed();
        if(result == true)
        {
            System.out.println("Test Successful");
        }
        else
        {
            System.out.println("Test failed!");
        }

        // close the chrome driver window
        driver.close();
    }
}
