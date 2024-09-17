package com.federal.checklist.service;
import com.federal.checklist.dao.ChecklistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistService {
    @Autowired
    ChecklistDao checklistDao;

    public String getChecklistData(String documentName , String sunConstitution,String customerType) {
        return checklistDao.getChecklistData(documentName,sunConstitution,customerType);
    }
}