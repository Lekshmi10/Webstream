package com.federal.checklist.dao;

import com.federal.checklist.model.Checklist;
import com.federal.checklist.model.Constitution;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ChecklistDao {

    @Autowired
    EntityManager entityManager;

    public Checklist addChecklistData(Checklist checklist) {

        try {
            int checklistId = this.getChecklistId() + 1;
            Checklist checklistObj = new Checklist();
            checklistObj.setId(checklistId);
            checklistObj.setDocumentName(checklist.getDocumentName());
            checklistObj.setSubConstitution(checklist.getSubConstitution());
            checklistObj.setChecklistPoints(checklist.getChecklistPoints());
            checklistObj.setCustomerType(checklist.getCustomerType());
            entityManager.persist(checklistObj);
            entityManager.flush();

            return checklistObj;

        } catch (Exception e) {
            return new Checklist();
        }
    }

    public String getChecklistData(String documentName, String subConstitution, String customerType) {
        try {

            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("From CHECKLIST as c where c.documentName=:documentName and c.subConstitution=:subConstitution and c.customerType=:customerType", Checklist.class);
            query.setParameter("documentName", documentName);
            query.setParameter("subConstitution", subConstitution);
            query.setParameter("customerType", customerType);
            List<Checklist> list = query.getResultList();
            if (list.size() != 0) {
                return list.get(0).getChecklistPoints();
            } else {
                return "false";
            }

        } catch (Exception e) {

            return "false";
        }
    }

    @Transactional
    public int getChecklistId() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("FROM CHECKLIST AS a ORDER BY a.id DESC",
                    Checklist.class);
            List<Checklist> list = query.getResultList();
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