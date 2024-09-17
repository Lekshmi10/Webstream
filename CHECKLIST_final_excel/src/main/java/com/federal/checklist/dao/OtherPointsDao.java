package com.federal.checklist.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class OtherPointsDao {

    @Value("${otherPoints.file.path}")
    private String otherPointsExcel;

    public String getOtherPointsData(String subConstitution) {
        try {
            FileInputStream excelFile = new FileInputStream(otherPointsExcel);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            List<String> otherPointsList = new ArrayList<>();
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                String rowSubConstitution = row.getCell(2).getStringCellValue();
                String otherPoints = row.getCell(1).getStringCellValue();

                if (rowSubConstitution.equals(subConstitution)) {
                    otherPointsList.add(otherPoints);
                }
            }

            if (otherPointsList.isEmpty()) {
                return "false";
            } else {
                return otherPointsList.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}






