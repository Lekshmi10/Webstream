package com.federal.checklist.model;



import javax.persistence.*;
import java.util.StringJoiner;

@Entity(name = "CHECKLIST_LOG_DATA")
@Table(name = "CHECKLIST_LOG_DATA")
public class ChecklistLogData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "check_log_seq")
    @SequenceGenerator(name = "check_log_seq", sequenceName = "check_log_seq", allocationSize = 1)
    @Column(name = "ID")
    private int id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "TIME")
    private String time;


    public String getDesignation() {
        return designation;
    }


    public void setDesignation(String value) {
        this.designation = value;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String value) {
        this.department = value;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String value) {
        this.username = value;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String value) {
        this.time = value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"designation:\"" + designation + "\"")
                .add("\"department:\"" + department + "\"")
                .add("\"username:\"" + username + "\"")
                .add("\"time:\"" + time + "\"")
                .toString();
    }
}
