package com.federal.checklist.service;




import com.federal.checklist.dao.LogDataDao;
import com.federal.checklist.model.ChecklistLogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class LogDataService {
    @Autowired
    LogDataDao logDataDao;

    public String saveLogData(String username,  String designation,  String department) {
         return logDataDao.saveLogData(username,designation,department);
    }

}
