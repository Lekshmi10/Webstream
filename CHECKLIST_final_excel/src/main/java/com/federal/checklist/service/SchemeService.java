package com.federal.checklist.service;

import com.federal.checklist.dao.SchemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemeService {
    @Autowired
    SchemeDao schemeDao;

    public String getSchemeData(String sectionName) {
        return schemeDao.getSchemeData(sectionName);
    }

}
