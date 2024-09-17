package com.federal.checklist.service;

import com.federal.checklist.dao.ConstitutionDao;
import com.federal.checklist.dao.DocumentsDao;
import com.federal.checklist.model.Constitution;
import com.federal.checklist.model.Documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DocumentsService {


    @Autowired
    DocumentsDao docDao;

    @Transactional
    public Documents addDocumentsData(Documents documents) {
        return docDao.addDocumentsData(documents);
    }

    public String getMandatoryDocumentsData(String accountType ,String customerType,String subConstitution,String schemeType,String constitutionType) {
        return docDao.getMandatoryDocumentsData(accountType,customerType,subConstitution,schemeType,constitutionType);
    }

}
