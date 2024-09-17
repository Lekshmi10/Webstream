package com.federal.checklist.dao;



import com.federal.checklist.model.ChecklistLogData;
import com.federal.checklist.model.Scheme;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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




    @Transactional
    public String saveLogData(String username, String designation,  String department) {

        try {
            ChecklistLogData logData = new ChecklistLogData();
            logData.setUsername(username);
            logData.setDesignation(designation);
            logData.setDepartment(department);
            Date date = new Date(System.currentTimeMillis());
            logData.setTime(date.toString());
            entityManager.persist(logData);
            entityManager.flush();
            return "success";
        } catch (Exception e) {
           return "failure";
        }
    }
}



