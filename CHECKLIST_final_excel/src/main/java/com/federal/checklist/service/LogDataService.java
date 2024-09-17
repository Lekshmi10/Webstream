package com.federal.checklist.service;

import com.federal.checklist.dao.LogDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogDataService {
    @Autowired
    LogDataDao logDataDao;


    public void saveLogData(String username,  String designation,  String department) {
         logDataDao.saveLogData(username,designation,department);
    }

}
