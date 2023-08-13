package com.facebooksignup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {

    WebDriver driver;

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\madhu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToFacebook() {
        driver.get("http://www.fb.com");
        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("http://www.facebook.com")) {
            System.out.println("Page is redirected to Facebook");
        } else {
            System.out.println("Page is not redirected to Facebook");
        }
    }

    public void signUp() {
        WebElement createAccount = driver.findElement(By.linkText("Create an account"));
        if (createAccount.isDisplayed()) {
            System.out.println("Create an account section is displayed");
            driver.findElement(By.name("firstname")).sendKeys("John");
            driver.findElement(By.name("lastname")).sendKeys("Doe");
            driver.findElement(By.name("reg_email__")).sendKeys("john.doe@gmail.com");
            driver.findElement(By.name("reg_email_confirmation__")).sendKeys("john.doe@gmail.com");
            driver.findElement(By.name("reg_passwd__")).sendKeys("password");
            Select day = new Select(driver.findElement(By.id("day")));
            day.selectByValue("15");
            Select month = new Select(driver.findElement(By.id("month")));
            month.selectByValue("2");
            Select year = new Select(driver.findElement(By.id("year")));
            year.selectByValue("1980");
            driver.findElement(By.xpath("//input[@value='2']")).click();
            createAccount.click();
            System.out.println("Account created successfully");
        } else {
            System.out.println("Create an account section is not displayed");
        }
    }
}
