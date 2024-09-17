package com.federal.checklist.service;

import com.federal.checklist.dao.OtherPointsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherPointsService {

    @Autowired
    OtherPointsDao otherPointsDao;

    public String getOtherPointsData(String subConstitution) {
        return otherPointsDao.getOtherPointsData(subConstitution);
    }
}
