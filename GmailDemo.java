package com.akshat.miqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        // path to chromedriver
        System.setProperty("webdriver.chrome.driver", "/home/akshat/Downloads/chromedriver");

        // create a chrome driver and direct it to goibibo site with full screen window
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();

        // enter some email address in email box
        driver.findElement(By.id("identifierId")).sendKeys("akshat.agarwal@gmail.com");

        // press next button
        driver.findElement(By.className("CwaK9")).click();

        // check if class of password box appeared then test is successful
        boolean result = driver.findElement(By.xpath("//*[contains(@class,'whsOnd zHQkBf')]")).isDisplayed();
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
