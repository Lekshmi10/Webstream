package com.federal.checklist.model;

import javax.persistence.*;

@Table(name = "OTHER_POINTS")
@Entity(name = "OTHER_POINTS")
public class OtherPoints {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for MySQL
    @Column(name = "ID")
    private int id;

    @Column(name = "SUB_CONSTITUTION")
    private String subConstitution;
    @Lob
    @Column(name = "OTHER_POINTS")
    private String otherPoints;

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

    public String getOtherPoints() {
        return otherPoints;
    }

    public void setOtherPoints(String otherPoints) {
        this.otherPoints = otherPoints;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ",\"subConstitution\":" + "\"" + subConstitution + "\"" +
                ",\"otherPoints\":" + "\"" + otherPoints + "\"" +
                '}';
    }
}
