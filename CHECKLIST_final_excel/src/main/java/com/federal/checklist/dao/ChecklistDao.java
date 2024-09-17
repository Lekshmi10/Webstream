package com.federal.checklist.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;


@Repository
public class ChecklistDao {


@Value("${checkListExcel.file.path}")
private String checkListExcelFilePath;


    public String getChecklistData(String documentName, String subConstitution, String customerType) {
        try {
            FileInputStream excelFile = new FileInputStream(checkListExcelFilePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }

                String documentNameCellValue = row.getCell(2).getStringCellValue();
                String subConstitutionCellValue = row.getCell(3).getStringCellValue();
                String customerTypeCellValue = row.getCell(4).getStringCellValue();
                String checklistPoints = row.getCell(1).getStringCellValue();

                if (documentName.equals(documentNameCellValue) &&
                        subConstitution.equals(subConstitutionCellValue) &&
                        customerType.equals(customerTypeCellValue)) {
                    return checklistPoints;
                }
            }

            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}






