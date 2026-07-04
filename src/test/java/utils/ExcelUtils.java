package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    Workbook workbook;
    Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public int getRowCount() {

        return sheet.getLastRowNum();

    }

    public int getColumnCount() {

        return sheet.getRow(0).getLastCellNum();

    }

    public String getCellData(int row, int col) {

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(sheet.getRow(row).getCell(col));

    }

    public Object[][] getSheetData() {

        Object[][] data = new Object[3][9];

        for (int i = 1; i <= 3; i++) {

            for (int j = 0; j < 9; j++) {

                data[i - 1][j] = getCellData(i, j);

            }

        }

        return data;
    }

}