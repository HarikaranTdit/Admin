package org.tdit.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCopilat {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://qa-bo-admin.smartsortsupport.com/login");
        driver.manage().window().maximize();

        System.out.println("Admin is launched successfully");
        Thread.sleep(3000);

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@id='email1']")));
        email.sendKeys("SSAdmin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@type='password']")));
        password.sendKeys("SSAdmin@123");

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[normalize-space()='Sign In']")));
        login.click();

        Thread.sleep(3000);

        WebElement overallMap = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(normalize-space(),'Overall Map')]")));
        overallMap.click();

        System.out.println("Overall Map screen opened successfully");

        selectFilter(wait, "Country Name", "Saudi Arabia");
        selectFilter(wait, "Region Name", "Eastern Region");
        selectFilter(wait, "City Name", "Bqaiq");
        selectFilter(wait, "District Name", "Ishbiliyah");
        selectFilter(wait, "Zone Name", "Ishbiliyah Zone 1");

        System.out.println("Overall Map filters selected successfully");
        System.out.println("Selected record:");
        System.out.println("Country: " + getSelectedFilterValue(wait, "Country Name"));
        System.out.println("Region: " + getSelectedFilterValue(wait, "Region Name"));
        System.out.println("City: " + getSelectedFilterValue(wait, "City Name"));
        System.out.println("District: " + getSelectedFilterValue(wait, "District Name"));
        System.out.println("Zone: " + getSelectedFilterValue(wait, "Zone Name"));

        driver.quit();
    }

    private static void selectFilter(WebDriverWait wait, String filterName, String optionName) {
        WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[self::label or self::span or self::div][normalize-space()='" + filterName
                + "']/following::*[self::input or self::button or @role='combobox'][1]")));
        filter.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[self::option or self::li or self::span or self::div][normalize-space()='"
                + optionName + "']")));
        option.click();
    }

    private static String getSelectedFilterValue(WebDriverWait wait, String filterName) {
        WebElement filter = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[self::label or self::span or self::div][normalize-space()='" + filterName
                + "']/following::*[self::input or self::button or @role='combobox'][1]")));
        String value = filter.getAttribute("value");
        return value == null || value.isBlank() ? filter.getText() : value;
    }
}

