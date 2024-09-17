package com.federal.checklist.service;

import com.federal.checklist.dao.ConstitutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsitutionService {

    @Autowired
    ConstitutionDao constitutionDao;


    public String getConstitutionData(String accountType ,String customerType,String specialScheme) {
        return constitutionDao.getConstitutionData(accountType,customerType,specialScheme);
    }

    public String getSubConstitutionData(String constitution , String accountType) {
        return constitutionDao.getSubConstitutionData(constitution,accountType);
    }

}
