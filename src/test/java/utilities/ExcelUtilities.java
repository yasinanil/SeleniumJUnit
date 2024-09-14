package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilities {
    private String filePath;
    private Workbook workbook;
    private Sheet sheet;

    // Constructor to initialize file path and sheet by name
    public ExcelUtilities(String filePath, String sheetName) {
        this.filePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName); // Get sheet by name

            if (sheet == null) {
                throw new RuntimeException("Sheet with name \"" + sheetName + "\" does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get cell value as a string
    public String getCellValue(int rowNum, int cellNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);

        if (cell == null) {
            return ""; // Return empty string if the cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    // Write data to Excel
    public void writeData(int rowNum, int cellNum, String value) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            cell = row.createCell(cellNum);
        }
        cell.setCellValue(value);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get row count of the sheet
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Get a column's data by row number
    public String[] getColumnData(int colNum) {
        int rowCount = getRowCount();
        String[] columnData = new String[rowCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(colNum);
                columnData[i] = cell != null ? cell.toString() : "";
            }
        }
        return columnData;
    }

    // Close the workbook
    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}