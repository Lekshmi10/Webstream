package com.federal.checklist.dao;

import com.federal.checklist.model.OtherPoints;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OtherPointsDao {


    @Autowired
    EntityManager entityManager;

    public OtherPoints addOtherPointsData(OtherPoints otherPoints) {

        try {
            OtherPoints otherObj = new OtherPoints();
            otherObj.setOtherPoints(otherPoints.getOtherPoints());
            otherObj.setSubConstitution(otherPoints.getSubConstitution());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(otherPoints);
            currentSession.close();
            return otherObj;

        } catch (Exception e) {
            return new OtherPoints();
        }

    }

    public String getOtherPointsData(String subConstitution) {
        try {

            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("From OTHER_POINTS as o where o.subConstitution=:subConstitution", OtherPoints.class);
            query.setParameter("subConstitution",subConstitution);
            List<OtherPoints> list = query.getResultList();
            if(list.size()!=0){
                return list.get(0).getOtherPoints();
            }else{
                return "false";
            }

        } catch (Exception e) {

            return "false";
        }
    }
}






