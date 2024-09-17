package com.federal.checklist.dao;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;


@Repository
public class ConstitutionDao {


    @Value("${constitutionExcel.file.path}")
    private String constitutionExcelFilePath;

    public String getConstitutionData(String accountType, String customerType, String specialScheme) {
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(constitutionExcelFilePath))) {
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String rowAccountType = getStringValue(row.getCell(1));
                String rowCustomerType = getStringValue(row.getCell(2));
                String rowSpecialScheme = getStringValue(row.getCell(5));

                if (accountType.equals(rowAccountType)
                        && customerType.equals(rowCustomerType)
                        && specialScheme.equals(rowSpecialScheme)) {
                    return getStringValue(row.getCell(3));
                }
            }

            return "false";

        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    private String getStringValue(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return null;
        }
    }

    public String getSubConstitutionData(String constitution, String accountType) {
        try {
            FileInputStream excelFile = new FileInputStream(constitutionExcelFilePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet("CONSTITUTION");

            for (Row row : sheet) {
                Cell accountTypeCell = row.getCell(1);
                Cell sectionNameCell = row.getCell(4);

                if (accountTypeCell != null && sectionNameCell != null) {
                    String accountTypeValue = accountTypeCell.getStringCellValue();
                    String sectionNameValue = sectionNameCell.getStringCellValue();

                    if (accountType.equals(accountTypeValue) && constitution.equals(sectionNameValue)) {
                        Cell sectionDataCell = row.getCell(3);
                        if (sectionDataCell != null) {
                            return sectionDataCell.getStringCellValue();
                        }
                    }
                }
            }
            return "false";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}
