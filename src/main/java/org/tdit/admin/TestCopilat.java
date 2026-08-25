package org.tdit.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCopilat {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://qa-bo-admin.smartsortsupport.com/login");
        driver.manage().window().maximize();

        System.out.println("Admin is launched successfully");

        WebElement email = driver.findElement(By.xpath("//input[@id='email1']"));
        email.sendKeys("SSAdmin");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("SSAdmin@123");

        WebElement login = driver.findElement(By.xpath("//span[normalize-space()='Sign In']"));
        login.click();

        WebElement overallMap = driver.findElement(By.xpath("//span[normalize-space()='Overall Map']"));
        overallMap.click();

        System.out.println("Overall Map screen opened successfully");

        WebElement countryName = driver.findElement(By.id("countryId"));
        countryName.click();
        driver.findElement(By.xpath("//*[@role='option' and normalize-space()='Saudi Arabia']")).click();

        WebElement regionName = driver.findElement(By.id("regionId"));
        regionName.click();
        driver.findElement(By.xpath("//*[@role='option' and normalize-space()='Eastern Region']")).click();

        WebElement cityName = driver.findElement(By.id("cityId"));
        cityName.click();
        driver.findElement(By.xpath("//*[@role='option' and normalize-space()='Bqaiq']")).click();

        WebElement districtName = driver.findElement(By.id("districtId"));
        districtName.click();
        driver.findElement(By.xpath("//*[@role='option' and normalize-space()='Ishbiliyah']")).click();

        WebElement zoneName = driver.findElement(By.id("zoneId"));
        zoneName.click();
        driver.findElement(By.xpath("//*[@role='option' and normalize-space()='Ishbilliyah Zone1']")).click();

        System.out.println("Country: " + countryName.getText());
        System.out.println("Region: " + regionName.getText());
        System.out.println("City: " + cityName.getText());
        System.out.println("District: " + districtName.getText());
        System.out.println("Zone: " + zoneName.getText());

        //driver.quit();



    }
}

