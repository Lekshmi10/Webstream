package com.federal.checklist.dao;

import com.federal.checklist.model.Scheme;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SchemeDao {
    @Autowired
    EntityManager entityManager;

    public Scheme addSchemeData(Scheme SchemeData) {

        try {
            Scheme scheme = new Scheme();
            scheme.setSectionName(SchemeData.getSectionName());
            scheme.setSchemes(SchemeData.getSchemes());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(SchemeData);
            currentSession.close();
            return SchemeData;

        } catch (Exception e) {
            return new Scheme();
        }

    }

    public String getSchemeData(String sectionName) {
        try {

            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("From SCHEME as s where s.sectionName=:sectionName", Scheme.class);
            query.setParameter("sectionName",sectionName);
            List<Scheme> list = query.getResultList();
            return list.get(0).getSchemes();

        } catch (Exception e) {

            return "false";
        }
    }
}
