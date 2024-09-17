package com.federal.checklist.model;

import javax.persistence.*;


@Table(name = "CHECKLIST")
@Entity(name = "CHECKLIST")
public class Checklist {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DOCUMENT_NAME")
    private String documentName;

    @Column(name = "SUB_CONSTITUTION")
    private String subConstitution;

    @Column(name = "CUSTOMER_TYPE")
    private String customerType;

    @Lob
    @Column(name = "CHECKLIST_POINTS", columnDefinition = "TEXT")
    private String checklistPoints;


    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getChecklistPoints() {
        return checklistPoints;
    }

    public void setChecklistPoints(String checklistPoints) {
        this.checklistPoints = checklistPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubConstitution() {
        return subConstitution;
    }

    public void setSubConstitution(String subConstitution) {
        this.subConstitution = subConstitution;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Checklist{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", subConstitution='" + subConstitution + '\'' +
                ", checklistPoints='" + checklistPoints + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}









