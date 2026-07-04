package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.SignupPage;
import utils.DataProviderClass;

public class SignupTest extends BaseTest {

    @Test(dataProvider = "SignupData", dataProviderClass = DataProviderClass.class)
    public void verifySignup(

            String tcId,
            String firstName,
            String lastName,
            String phone,
            String email,
            String password,
            String confirmPassword,
            String terms,
            String expected

    ) throws InterruptedException {

        System.out.println("Running : " + tcId);

        LandingPage landing = new LandingPage(driver);
        landing.clickTopSignIn();

        LoginPage login = new LoginPage(driver);

        login.enterEmail(email);
        login.clickContinue();

        SignupPage signup = new SignupPage(driver);

        signup.enterFirstName(firstName);
        signup.enterLastName(lastName);
        signup.enterPhone(phone);
        signup.enterPassword(password);
        signup.enterConfirmPassword(confirmPassword);

        if (terms.equalsIgnoreCase("Yes")) {
            signup.clickTerms();
        }

        signup.clickSignUp();

        // Positive testcase
        if (expected.equalsIgnoreCase("Verify Account Page")) {

            Assert.assertTrue(signup.verifyAccountPageDisplayed());

        }

        // First Name Mandatory
        else if (expected.equalsIgnoreCase("First Name Mandatory")) {

            Assert.assertTrue(signup.isFirstNameErrorDisplayed());

        }

        // Password Mismatch
        else if (expected.equalsIgnoreCase("Password Mismatch")) {

            Assert.assertTrue(signup.isPasswordMismatchErrorDisplayed());

        }

        // Terms Mandatory
        else if (expected.equalsIgnoreCase("Terms Required")) {

            Assert.assertTrue(signup.isTermsErrorDisplayed());

        }

        System.out.println(tcId + " Completed");
    }
}