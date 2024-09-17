package com.federal.checklist.dao;

import com.federal.checklist.model.Documents;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.DataInput;
import java.util.List;

@Repository

public class DocumentsDao {
    @Autowired
    EntityManager entityManager;

    public String getMandatoryDocumentsData(String accountType, String customerType, String subConstitution, String schemeType, String constitutionType) {
        try {
            String secName = "";
            Session currentSession = entityManager.unwrap(Session.class);

            Query query = currentSession.createQuery("From DOCUMENTS c where c.accountType=:accountType and c.customerType=:customerType and c.subConstitution=:subConstitution and c.schemeType=:schemeType and c.constitutionType=:constitutionType", Documents.class);
            query.setParameter("accountType", accountType);
            query.setParameter("customerType", customerType);
            query.setParameter("schemeType", schemeType);
            query.setParameter("subConstitution", subConstitution);
            query.setParameter("constitutionType", constitutionType);
            List<Documents> list = query.getResultList();
            return list.get(0).getDocuments();

        } catch (Exception e) {

            return "false";
        }
    }

    public Documents addDocumentsData(Documents documents) {

        try {
            int docId = this.getDocumentsId() + 1;
            Documents documentsObj = new Documents();
            documentsObj.setId(docId);
            documentsObj.setAccountType(documents.getAccountType());
            documentsObj.setCustomerType(documents.getCustomerType());
            documentsObj.setSubConstitution(documents.getSubConstitution());
            documentsObj.setDocuments(documents.getDocuments().toString());
            documentsObj.setSchemeType(documents.getSchemeType());
            documentsObj.setConstitutionType(documents.getConstitutionType());
            entityManager.persist(documentsObj);
            entityManager.flush();
            return documentsObj;

        } catch (Exception e) {
            return new Documents();
        }
    }

    @Transactional
    public int getDocumentsId() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("FROM DOCUMENTS AS a ORDER BY a.id DESC",
                    Documents.class);
            List<Documents> list = query.getResultList();
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
