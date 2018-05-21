package com.softvision.taipc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Document(collection = "candidate")
public class Candidate implements Comparable<Candidate> {


    @Id
    @Min(value=0,message="Candidate Id cannot be null or empty")
    private String id;
    
    @NotNull(message = "Candidate First Name cannot be null")
    @NotEmpty(message="Candidate First Name cannot empty")
    @Size(min = 2, max = 100, message = "Candidate First Name must be atleast 2 and 100 characters")
    private String firstName;
    
    @NotNull(message = "Candidate Last Name cannot be null")
    private String lastName;
    
    @Email(message = "Candidate Email should be valid")
    private String mailID;
    
    @Pattern(regexp="(^$|[0-9]{10})",message="Invalid Phone number")
    private String phoneNumber;

    private Recruiter recruiter;
    private List<Panel> panelList;
    private List<Panel> backupPanelList;
    private LocalDateTime appliedDate;
    private List<LocalDateTime> scheduleDates;
    private LocalDateTime creationTime;
    private LocalDateTime modifiedTime;
    private String createdBy;
    private String modifiedBy;
    private State currentState;
    private List<State> previousState;
    private Role appliedRole;
    private Role approvedRole;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName,
                     String mailID, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailID = mailID;
        this.phoneNumber = phoneNumber;
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

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public List<Panel> getBackupPanelList() {
        return backupPanelList;
    }

    public void setBackupPanelList(List<Panel> backupPanelList) {
        this.backupPanelList = backupPanelList;
    }

    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }

    public List<LocalDateTime> getScheduleDates() {
        return scheduleDates;
    }

    public void setScheduleDates(List<LocalDateTime> scheduleDates) {
        this.scheduleDates = scheduleDates;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public List<State> getPreviousState() {
        return previousState;
    }

    public void setPreviousState(List<State> previousState) {
        this.previousState = previousState;
    }

    public List<Panel> getPanelList() {
        return panelList;
    }

    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }

    public Role getAppliedRole() {
        return appliedRole;
    }

    public void setAppliedRole(Role appliedRole) {
        this.appliedRole = appliedRole;
    }

    public Role getApprovedRole() {
        return approvedRole;
    }

    public void setApprovedRole(Role approvedRole) {
        this.approvedRole = approvedRole;
    }

    @Override
    public String toString() {
        return String.format(
                "Candidate[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(getId(), candidate.getId()) &&
                Objects.equals(getFirstName(), candidate.getFirstName()) &&
                Objects.equals(getLastName(), candidate.getLastName()) &&
                Objects.equals(getMailID(), candidate.getMailID()) &&
                Objects.equals(getPhoneNumber(), candidate.getPhoneNumber()) &&
                Objects.equals(getRecruiter(), candidate.getRecruiter()) &&
                Objects.equals(getPanelList(), candidate.getPanelList()) &&
                Objects.equals(getBackupPanelList(), candidate.getBackupPanelList()) &&
                Objects.equals(getAppliedDate(), candidate.getAppliedDate()) &&
                Objects.equals(getScheduleDates(), candidate.getScheduleDates()) &&
                Objects.equals(getCreationTime(), candidate.getCreationTime()) &&
                Objects.equals(getModifiedTime(), candidate.getModifiedTime()) &&
                Objects.equals(getCreatedBy(), candidate.getCreatedBy()) &&
                Objects.equals(getModifiedBy(), candidate.getModifiedBy()) &&
                Objects.equals(getCurrentState(), candidate.getCurrentState()) &&
                Objects.equals(getPreviousState(), candidate.getPreviousState()) &&
                getAppliedRole() == candidate.getAppliedRole() &&
                getApprovedRole() == candidate.getApprovedRole();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getMailID(), getPhoneNumber(), getRecruiter(), getPanelList(), getBackupPanelList(), getAppliedDate(), getScheduleDates(), getCreationTime(), getModifiedTime(), getCreatedBy(), getModifiedBy(), getCurrentState(), getPreviousState(), getAppliedRole(), getApprovedRole());
    }

    @Override
    public int compareTo(Candidate o) {
        int val = 0 ;
        if(this.getFirstName().compareTo(o.getFirstName()) == -1 ) {
            val = -1;
        } else if( this.getFirstName().compareTo(o.getFirstName()) == 1) {
            val = 1;
        }
        return val;
    }
}
