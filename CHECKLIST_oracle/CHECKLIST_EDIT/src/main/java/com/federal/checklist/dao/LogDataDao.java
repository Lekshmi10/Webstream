package com.federal.checklist.dao;



import com.federal.checklist.model.ChecklistLogData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class LogDataDao {


    @Autowired
    EntityManager entityManager;




    public void saveLogData(String username, String designation,  String department) {
        ChecklistLogData logData = new ChecklistLogData();
        logData.setUsername(username);
        logData.setDesignation(designation);
        logData.setDepartment(department);
        Date date = new Date(System.currentTimeMillis());
        logData.setTime(date.toString());
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(logData);
        currentSession.close();
    }
}



