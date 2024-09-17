package com.federal.checklist.service;

import com.federal.checklist.dao.DocumentsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentsService {


    @Autowired
    DocumentsDao docDao;

    public String getDocumentsData(String accountType ,String customerType,String subConstitution,String schemeType,String constitutionType) {
        return docDao.getDocumentsData(accountType,customerType,subConstitution,schemeType,constitutionType);
    }

}
