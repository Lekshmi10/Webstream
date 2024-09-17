package com.federal.checklist.dao;

import com.federal.checklist.model.Scheme;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SchemeDao {
    @Autowired
    EntityManager entityManager;
@Transactional
    public Scheme addSchemeData(Scheme SchemeData) {

        try {
            int schemeId = this.getSchemeId() + 1;
            Scheme scheme = new Scheme();
            scheme.setId(schemeId);
            scheme.setSectionName(SchemeData.getSectionName());
            scheme.setSchemes(SchemeData.getSchemes());
            entityManager.persist(scheme);
            entityManager.flush();
            return scheme;

        } catch (Exception e) {
            return new Scheme();
        }
    }

    public String getSchemeData(String sectionName) {
        try {

            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("From SCHEME as s where s.sectionName=:sectionName", Scheme.class);
            query.setParameter("sectionName", sectionName);
            List<Scheme> list = query.getResultList();
            return list.get(0).getSchemes();

        } catch (Exception e) {

            return "false";
        }
    }

    @Transactional
    public int getSchemeId() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("FROM SCHEME AS a ORDER BY a.id DESC",
                    Scheme.class);
            List<Scheme> list = query.getResultList();
            currentSession.close();
            if (list.isEmpty()) {
                return 0;
            } else {
                return list.get(0).getId();
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
