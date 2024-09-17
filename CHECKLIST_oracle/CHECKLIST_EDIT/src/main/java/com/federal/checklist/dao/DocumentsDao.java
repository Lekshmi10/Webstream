package com.federal.checklist.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.checklist.model.Constitution;
import com.federal.checklist.model.Documents;

import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.DataInput;
import java.util.List;

@Repository

public class DocumentsDao {
    @Autowired
    EntityManager entityManager;

    public String getMandatoryDocumentsData(String accountType ,String customerType,String subConstitution,String schemeType,String constitutionType) {
        try {
            String secName="";
            Session currentSession = entityManager.unwrap(Session.class);

                Query query = currentSession.createQuery("From DOCUMENTS c where c.accountType=:accountType and c.customerType=:customerType and c.subConstitution=:subConstitution and c.schemeType=:schemeType and c.constitutionType=:constitutionType",Documents.class);
                query.setParameter("accountType",accountType);
                query.setParameter("customerType",customerType);
                query.setParameter("schemeType",schemeType);
                query.setParameter("subConstitution",subConstitution);
                query.setParameter("constitutionType",constitutionType);
                List<Documents> list = query.getResultList();
                return list.get(0).getDocuments();



        } catch (Exception e) {

            return "false";
        }
    }

    public Documents addDocumentsData(Documents documents){

        try {
            Documents documentsObj = new Documents();
            documentsObj.setAccountType(documents.getAccountType());
            documentsObj.setCustomerType(documents.getCustomerType());
            documentsObj.setSubConstitution(documents.getSubConstitution());
            documentsObj.setDocuments(documents.getDocuments().toString());
            documentsObj.setSchemeType(documents.getSchemeType());
            documentsObj.setConstitutionType(documents.getConstitutionType());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(documentsObj);
            currentSession.close();
            return documentsObj;

        } catch (Exception e) {
            return new Documents();
        }

    }
}
