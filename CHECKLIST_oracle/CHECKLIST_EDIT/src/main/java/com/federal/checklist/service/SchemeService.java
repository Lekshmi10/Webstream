package com.federal.checklist.service;

import com.federal.checklist.dao.SchemeDao;
import com.federal.checklist.model.Scheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchemeService {
    @Autowired
    SchemeDao schemeDao;

    @Transactional
    public Scheme addSchemeData(Scheme schemeData) {
        return schemeDao.addSchemeData(schemeData);
    }

    public String getSchemeData(String sectionName) {
        return schemeDao.getSchemeData(sectionName);
    }



}
