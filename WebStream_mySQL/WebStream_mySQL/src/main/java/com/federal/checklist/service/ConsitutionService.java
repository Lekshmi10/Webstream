package com.federal.checklist.service;

import com.federal.checklist.dao.ConstitutionDao;
import com.federal.checklist.model.Constitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class ConsitutionService {

    @Autowired
    ConstitutionDao constitutionDao;


    public Constitution addConstitutionData(Constitution constitution) {
        return constitutionDao.addConstitutionData(constitution);
    }

    public String getConstitutionData(String accountType ,String customerType,String specialScheme) {
        return constitutionDao.getConstitutionData(accountType,customerType,specialScheme);
    }

    public String getSubConstitutionData(String constitution , String accountType) {
        return constitutionDao.getSubConstitutionData(constitution,accountType);
    }

}
