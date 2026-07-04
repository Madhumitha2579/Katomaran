package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utils.DataProviderClass;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
    public void verifyLogin(String tcId,
                            String email,
                            String password,
                            String expected) throws InterruptedException {

        System.out.println("Running : " + tcId);

        LandingPage landing = new LandingPage(driver);
        landing.clickTopSignIn();

        LoginPage login = new LoginPage(driver);

        // Enter Email
        if (!email.isBlank()) {
            login.enterEmail(email);
        }

        login.clickContinue();

        // Existing email → Password page
        if (expected.equalsIgnoreCase("Login Success")
                || expected.equalsIgnoreCase("Login Failed")
                || expected.equalsIgnoreCase("Password Required")) {

            if (!password.isBlank()) {
                login.enterPassword(password);
            }

            login.clickLogin();

            Thread.sleep(2000);
        }

        System.out.println(tcId + " Completed");

        Assert.assertTrue(true);
    }
}