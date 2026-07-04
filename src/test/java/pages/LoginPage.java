package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Email
    By emailTextbox = By.id("email");

    // Continue
    By continueButton =
            By.xpath("//button[@type='submit' and normalize-space()='Continue']");

    // Continue with Google
    By googleButton =
            By.xpath("//span[text()='Continue with Google']");

    // Password
    By passwordTextbox = By.id("password");

    // Login
    By loginButton =
            By.xpath("//button[@type='submit' and normalize-space()='Login']");


    // ===========================
    // Methods
    // ===========================

    public void enterEmail(String email) {

        WebElement txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailTextbox));

        txt.clear();
        txt.sendKeys(email);
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickContinueWithGoogle() {

        wait.until(
                ExpectedConditions.elementToBeClickable(googleButton)).click();
    }

    public void enterPassword(String password) {

        WebElement txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordTextbox));

        txt.click();
        txt.clear();
        txt.sendKeys(password);
    }

    public void clickLogin() {

        WebElement btn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginButton));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", btn);
    }

}