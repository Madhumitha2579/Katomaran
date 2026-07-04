package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    WebDriver driver;
    WebDriverWait wait;

    public LandingPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Top Sign In
    By topSignIn = By.xpath("//a[@href='/login']//button");

    // Bottom Sign Up
    By bottomSignUp = By.xpath("//a[@href='/login' and contains(text(),'Sign Up Now')]");

    public void clickTopSignIn() {

        wait.until(ExpectedConditions.elementToBeClickable(topSignIn)).click();
    }

    public void clickBottomSignUp() {

        wait.until(ExpectedConditions.elementToBeClickable(bottomSignUp)).click();
    }

}