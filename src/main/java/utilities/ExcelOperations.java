package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class ExcelOperations {
    private String filePath;
    private Sheet sheet;
    public ExcelOperations() {
        try {
            filePath = System.getProperty("user.dir") + Configuration.getPropertyValue("filepath");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File(filePath);

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet("InsurancePremium");
    }

    public HashMap<String, String> readExceldata(int rownum) throws IOException {
        DataFormatter formatter = new DataFormatter();
        HashMap<String, String> excelMap = new HashMap<>();

        for(int i=0; i<sheet.getRow(rownum).getLastCellNum(); i++) {
            Cell cell = sheet.getRow(rownum).getCell(i);
            String cellValue = formatter.formatCellValue(cell);
            excelMap.put(sheet.getRow(0).getCell(i).toString(), cellValue);
        }
        return excelMap;
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }


//    public static void main(String[] args) throws IOException {
//        ExcelOperations operations = new ExcelOperations();
//
//        int rows = operations.getRowCount();
//        int columns = operations.getColumnCount();
//
//        System.out.println(" rows ,"+rows+" columns ,"+columns);
//
//        Object[][] object = new Object[rows][1];
//
//        for(int i=1; i<=rows; i++) {
//            HashMap<String, String> dataMap = operations.readExceldata(i);
//            //object[i=1][0] = dataMap;
//            System.out.println(dataMap);
//        }
//
//    }


}
