package com.softvision.taipc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "Panel")
public class Panel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String mailID;
    private String phoneNumber;
    private List<String> panelTechnology;
    private List<String> panelLevel;


    public Panel() {}

    public Panel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Panel[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panel panel = (Panel) o;
        return Objects.equals(getId(), panel.getId()) &&
                Objects.equals(getFirstName(), panel.getFirstName()) &&
                Objects.equals(getLastName(), panel.getLastName()) &&
                Objects.equals(getMailID(), panel.getMailID()) &&
                Objects.equals(getPhoneNumber(), panel.getPhoneNumber()) &&
                Objects.equals(panelTechnology, panel.panelTechnology) &&
                Objects.equals(panelLevel, panel.panelLevel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getMailID(), getPhoneNumber(), panelTechnology, panelLevel);
    }
}
