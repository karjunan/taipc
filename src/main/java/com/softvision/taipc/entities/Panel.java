package com.softvision.taipc.entities;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.softvision.taipc.validation.NotContainNull;
import java.util.Objects;

@Document(collection = "Panel")
public class Panel {

    @Id
    @Min(value=0,message="Panel Id cannot be null or empty")
    private String id;
    
    @NotNull(message = "Panel First Name cannot be null")
    @NotEmpty(message="Panel First Name cannot empty")
    @Size(min = 2, max = 100, message = "Panel First Name must be atleast 2 and 100 characters")
    private String firstName;
    
    @NotNull(message = "Panel Last Name cannot be null")
    private String lastName;
    
    @Email(message = "Email should be valid")
    private String mailID;
    
    @Pattern(regexp="(^$|[0-9]{10})",message="Invalid Phone number")
    private String phoneNumber;
    
    @NotEmpty(message="At least one technology must be provided")
//	@NotContainNull(message="Panel Technology list cannot contain null")
	@Valid
    private List<String> panelTechnology;
    
    @NotEmpty(message="At least one panelLevel must be provided")
//   	@NotContainNull(message="panelLevel list cannot contain null")
   	@Valid
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
