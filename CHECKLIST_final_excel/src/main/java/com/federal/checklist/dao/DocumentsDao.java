package com.federal.checklist.dao;

import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Repository

public class DocumentsDao {

    @Value("${documentsExcel.file.path}")
    private String documentsExcel;

    public String getDocumentsData(String accountType, String customerType, String subConstitution, String schemeType, String constitutionType) {
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(documentsExcel))) {
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String rowAccountType = getStringValue(row.getCell(1));
                String rowCustomerType = getStringValue(row.getCell(2));
                String rowMandatoryDocuments = getStringValue(row.getCell(3));
                String rowKycDocuments = getStringValue(row.getCell(4));
                String rowSubConstitution = getStringValue(row.getCell(5));
                String rowSchemeType = getStringValue(row.getCell(6));
                String rowConstitutionType = getStringValue(row.getCell(7));

                if (accountType.equals(rowAccountType)
                        && customerType.equals(rowCustomerType)
                        && schemeType.equals(rowSchemeType)
                        && subConstitution.equals(rowSubConstitution)
                        && constitutionType.equals(rowConstitutionType)) {

                    StringBuilder result = new StringBuilder(rowMandatoryDocuments);

                    // Check if rowKycDocuments is not "-"
                    if (!"-".equals(rowKycDocuments) && !rowKycDocuments.isEmpty()) {
                        result.append("&&").append(rowKycDocuments);
                    }

                    return result.toString();
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
            return "";
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

}