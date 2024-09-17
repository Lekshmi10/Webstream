package com.federal.checklist.model;


import javax.persistence.*;

@Entity(name = "CONSTITUTION")
@Table(name = "CONSTITUTION")

public class Constitution {


//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "constitution_generator")
//    @SequenceGenerator(name = "constitution_generator", sequenceName = "constitution_generator", allocationSize = 1)

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "CUSTOMER_TYPE")
    private String customerType;

    @Column(name = "SPECIAL_SCHEME")
    private String specialScheme;

    @Column(name = "SECTION_NAME")
    private String sectionName;

    @Lob
    @Column(name = "SECTION_DATA")
    private String sectionData;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionData() {
        return sectionData;
    }

    public void setSectionData(String sectionData) {
        this.sectionData = sectionData;
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

    public String getSpecialScheme() {
        return specialScheme;
    }

    public void setSpecialScheme(String specialScheme) {
        this.specialScheme = specialScheme;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ",\"accountType\":" + "\"" + accountType + "\"" +
                ",\"customerType\":" + "\"" + customerType + "\"" +
                ",\"specialScheme\":" + "\"" + specialScheme + "\"" +
                ",\"sectionName\":" + "\"" + sectionName + "\"" +
                ",\"sectionData\":" + sectionData + "\"" +
                '}';
    }
}
