package com.federal.checklist.model;

import javax.persistence.*;

@Entity(name = "SCHEME")
@Table(name = "SCHEME")

public class Scheme {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheme_generator")
    @SequenceGenerator(name = "scheme_generator", sequenceName = "scheme_generator", allocationSize = 1)

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "SECTION_NAME")
    private String sectionName;

    @Lob
    @Column(name = "SECTION_DATA")
    private String schemes;

    public String getSectionName() {
        return sectionName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchemes() {
        return schemes;
    }

    public void setSchemes(String schemes) {
        this.schemes = schemes;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }



    @Override
    public String toString() {
        return "{" +
                ",\"id\":" + "\"" + id + "\"" +
                ",\"sectionName\":" + "\"" + sectionName + "\"" +
                ",\"schemes\":" + schemes + "\"" +
                '}';
    }


}
