package org.tdit.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCopilat {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://qa-bo-admin.smartsortsupport.com/login");
            driver.manage().window().maximize();

            System.out.println("Admin is launched successfully");

            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email1")));
            email.sendKeys("SSAdmin");

            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@type='password']")));
            password.sendKeys("S$Admin#");

            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(normalize-space(), 'Sign In')]")));
            login.click();

            WebElement overallMap = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(normalize-space(), 'Overall Map')]")));
            overallMap.click();

            wait.until(ExpectedConditions.urlContains("map"));
            System.out.println("Overall Map screen opened successfully");
        } finally {
            driver.quit();
        }
    }
}
