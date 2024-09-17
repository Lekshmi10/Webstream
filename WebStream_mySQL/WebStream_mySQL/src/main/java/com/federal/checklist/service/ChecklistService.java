package com.federal.checklist.service;
import com.federal.checklist.dao.ChecklistDao;
import com.federal.checklist.model.Checklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChecklistService {
    @Autowired
    ChecklistDao checklistDao;

    @Transactional
    public Checklist addChecklistData(Checklist checklist) {
        return checklistDao.addChecklistData(checklist);
    }

    public String getChecklistData(String documentName , String sunConstitution,String customerType) {
        return checklistDao.getChecklistData(documentName,sunConstitution,customerType);
    }
}