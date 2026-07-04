package utils;

public class ExcelReader {

    private static final String FILE_PATH = "testdata/TestData.xlsx";

    public static Object[][] getLoginData() {

        ExcelUtils excel = new ExcelUtils(FILE_PATH, "LoginData");

        return excel.getSheetData();

    }

    public static Object[][] getSignupData() {

        ExcelUtils excel = new ExcelUtils(FILE_PATH, "SignupData");

        return excel.getSheetData();

    }

}