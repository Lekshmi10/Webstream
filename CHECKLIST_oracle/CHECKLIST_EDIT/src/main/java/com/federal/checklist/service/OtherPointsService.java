package com.federal.checklist.service;

import com.federal.checklist.dao.OtherPointsDao;

import com.federal.checklist.model.OtherPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherPointsService {

    @Autowired
    OtherPointsDao otherPointsDao;

    @Transactional
    public OtherPoints addOtherPointsData(OtherPoints otherPoints) {
        return otherPointsDao.addOtherPointsData(otherPoints);
    }

    public String getOtherPointsData(String subConstitution) {
        return otherPointsDao.getOtherPointsData(subConstitution);
    }
}
