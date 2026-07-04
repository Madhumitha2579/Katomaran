package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {

        return ExcelReader.getLoginData();

    }

    @DataProvider(name = "SignupData")
    public Object[][] signupData() {

        return ExcelReader.getSignupData();

    }

}