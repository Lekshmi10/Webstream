package com.federal.checklist.dao;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.Date;
import org.springframework.stereotype.Repository;

@Repository
public class LogDataDao {

    @Value("${logExcel.file.path}")
    private String logExcelPath;


    private static final String[] COLUMN_NAMES = {"ID", "USERNAME", "DESIGNATION", "DEPARTMENT", "TIME"};

    public void saveLogData(String username, String designation, String department) {
        try {
            Workbook workbook;
            Sheet sheet;

            File excelFile = new File(logExcelPath);

            if (excelFile.exists()) {
                workbook = WorkbookFactory.create(new FileInputStream(logExcelPath));
                sheet = workbook.getSheetAt(0);
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet();

                Row headerRow = sheet.createRow(0);
                insertColumnHeadings(headerRow);
            }

            int lastInsertedId = getLastInsertedId();
            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

            lastInsertedId++;
            Cell cellId = newRow.createCell(0);
            cellId.setCellValue(lastInsertedId);

            Cell cellUsername = newRow.createCell(1);
            cellUsername.setCellValue(username);

            Cell cellDesignation = newRow.createCell(2);
            cellDesignation.setCellValue(designation);

            Cell cellDepartment = newRow.createCell(3);
            cellDepartment.setCellValue(department);

            Cell cellTime = newRow.createCell(4);
            cellTime.setCellValue(new Date().toString());

            setLastInsertedId(lastInsertedId);

            try (FileOutputStream fileOut = new FileOutputStream(logExcelPath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertColumnHeadings(Row headerRow) {
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(COLUMN_NAMES[i]);
        }
    }

    private int getLastInsertedId() {

        File idFile = new File("lastInsertedId.txt");

        if (idFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(idFile))) {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    private void setLastInsertedId(int lastInsertedId) {
        File idFile = new File("lastInsertedId.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(idFile))) {
            writer.write(String.valueOf(lastInsertedId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

