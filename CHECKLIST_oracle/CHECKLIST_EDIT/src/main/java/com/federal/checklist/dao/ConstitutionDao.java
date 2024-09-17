package com.federal.checklist.dao;


import com.federal.checklist.model.Constitution;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class ConstitutionDao {

    @Autowired
    EntityManager entityManager;
    public Constitution addConstitutionData(Constitution constitution){

        try {
            Constitution constitutionObj = new Constitution();
            constitutionObj.setAccountType(constitution.getAccountType());
            constitutionObj.setCustomerType(constitution.getCustomerType());
            constitutionObj.setSectionName(constitution.getSectionName());
            constitutionObj.setSpecialScheme(constitution.getSpecialScheme());
            constitutionObj.setSectionData(constitution.getSectionData().toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(constitutionObj);
            currentSession.close();
            return constitution;

        } catch (Exception e) {
            return new Constitution();
        }

    }
    public String getConstitutionData(String accountType ,String customerType ,String specialScheme) {
        try {
            String secName="";
            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("From CONSTITUTION c where c.accountType=:accountType and c.customerType=:customerType and c.specialScheme=:specialScheme and c.sectionName=:secName",Constitution.class);
            query.setParameter("specialScheme",specialScheme);
            query.setParameter("accountType",accountType);
            query.setParameter("customerType",customerType);
            query.setParameter("secName","CONSTITUTION");
            List<Constitution> list = query.getResultList();
            return list.get(0).getSectionData();

        } catch (Exception e) {

            return "false";
        }
    }

    public String getSubConstitutionData(String constitution , String accountType) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("From CONSTITUTION c where c.sectionName=:constitution and c.accountType=:accountType",Constitution.class);
            query.setParameter("constitution",constitution);
            query.setParameter("accountType",accountType);
            List<Constitution> list = query.getResultList();
            return list.get(0).getSectionData();

        } catch (Exception e) {

            return "false";
        }
    }
}
