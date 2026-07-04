package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By phone = By.id("phoneNumber");
    By password = By.id("password");
    By confirmPassword = By.id("confirmPassword");
    By terms = By.id("remember");

    By signUpBtn = By.xpath("//button[normalize-space()='Sign Up']");

    By verifyAccount =
            By.xpath("//h2[text()='Verify your account']");

    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterPhone(String num) {
        driver.findElement(phone).sendKeys(num);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public boolean isFirstNameErrorDisplayed() {

        return driver.getPageSource().contains("First name is mandatory");

    }

    public boolean isPasswordMismatchErrorDisplayed() {

        return driver.getPageSource().contains("Passwords do not match");

    }

    public boolean isTermsErrorDisplayed() {

        return driver.getPageSource().contains("Terms");

    }
    public void enterConfirmPassword(String pass) {
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickTerms() {
        driver.findElement(terms).click();
    }

    public void clickSignUp() {

        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();

    }

    public boolean verifyAccountPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(verifyAccount)
        ).isDisplayed();

    }
}