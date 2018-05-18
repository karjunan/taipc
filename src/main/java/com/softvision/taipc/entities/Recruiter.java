package com.softvision.taipc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "recruiter")
public class Recruiter {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String mailID;
    private String phoneNumber;

    public Recruiter() {
    }

    public Recruiter(String firstName, String lastName) {
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
                "Recruiter[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return Objects.equals(getId(), recruiter.getId()) &&
                Objects.equals(getFirstName(), recruiter.getFirstName()) &&
                Objects.equals(getLastName(), recruiter.getLastName()) &&
                Objects.equals(getMailID(), recruiter.getMailID()) &&
                Objects.equals(getPhoneNumber(), recruiter.getPhoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getMailID(), getPhoneNumber());
    }
}
