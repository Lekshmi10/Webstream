package com.federal.checklist.model;

import javax.persistence.*;

@Entity(name = "DOCUMENTS")
@Table(name = "DOCUMENTS")
public class Documents {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documents_generator")
    @SequenceGenerator(name = "documents_generator", sequenceName = "documents_generator", allocationSize = 1)

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "CUSTOMER_TYPE")
    private String customerType;
    @Column(name = "SUB_CONSTITUTION")
    private String subConstitution;
    @Column(name = "SCHEME")
    private String schemeType;
    @Column(name = "CONSTITUTION")
    private String constitutionType;

    @Lob
    @Column(name = "DOCUMENTS")
    private String documents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getSubConstitution() {
        return subConstitution;
    }

    public void setSubConstitution(String subConstitution) {
        this.subConstitution = subConstitution;
    }


    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public String getConstitutionType() {
        return constitutionType;
    }

    public void setConstitutionType(String constitutionType) {
        this.constitutionType = constitutionType;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ",\"accountType\":" + "\"" + accountType + "\"" +
                ",\"customerType\":" + "\"" + customerType + "\"" +
                ",\"subConstitution\":" + "\"" + subConstitution + "\"" +
                ",\"schemeType\":" + "\"" + schemeType + "\"" +
                ",\"constitutionType\":" + "\"" + constitutionType + "\"" +
                ",\"documents\":" + "\"" + documents + "\"" +
                '}';
    }
}
