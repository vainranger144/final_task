package com.example.saucedemo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTests {
    private static final Logger logger = LogManager.getLogger(LoginTests.class);
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = BrowserFactory.getBrowser("chrome"); // Или "edge"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEmptyCredentials() {
        logger.info("Testing with empty credentials");
        driver.findElement(By.id("login-button")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assertThat(errorMessage.getText(), containsString("Username is required"));
    }

    @Test
    public void testPasswordMissing() {
        logger.info("Testing with username but no password");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assertThat(errorMessage.getText(), containsString("Password is required"));
    }

    @ParameterizedTest
    @MethodSource("com.example.saucedemo.TestDataProvider#validUserCredentials")
    public void testValidLogin(String username, String password) {
        logger.info("Testing valid login for user: " + username);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        assertThat(driver.getTitle(), containsString("Swag Labs"));
    }
}

