package com.federal.checklist.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Repository
public class SchemeDao {

    @Value("${schemeExcel.file.path}")
    private String schemeExcelFilePath;

    public String getSchemeData(String sectionName) {
        try {
            FileInputStream file = new FileInputStream(new File(schemeExcelFilePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String currentSectionName = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

                if (sectionName.equalsIgnoreCase(currentSectionName)) {
                    String sectionData = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                    file.close();
                    return sectionData;
                }
            }

            file.close();
            return "false";

        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
