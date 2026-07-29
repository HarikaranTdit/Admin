package org.tdit.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-bo-admin.smartsortsupport.com/login");
        driver.manage().window().maximize();

        System.out.println("Admin is launched successfully");
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.id("email1"));
        email.sendKeys("SSAdmin");

        WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("S$Admin#");

        WebElement login=driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
        login.click();

        Thread.sleep(3000);
        
       WebElement overallMap= driver.findElement(By.xpath("//span[contains(text(),'Overall Map')]"));
       overallMap.click();





        //driver.close();


        // driver.quit();
    }
}