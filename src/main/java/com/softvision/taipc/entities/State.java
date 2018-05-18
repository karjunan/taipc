package com.softvision.taipc.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class State {

	@Id
	@Min(value=0,message="Candidate Id cannot be null or empty")
    private String id;
	
	@NotNull(message = "status cannot be null")
    private Status status;
	
	@NotNull(message="Created Date cycle")
    private LocalDateTime createdDate;
	
	@NotNull(message="Modified Date cycle")
    private LocalDateTime modifiedDate;
	
	@NotNull(message = "status cannot be null")
    private String createdBy;
    
	@NotNull(message = "status cannot be null")
    private String modifiedBy;

    public State() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = LocalDateTime.now();
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(getId(), state.getId()) &&
                getStatus() == state.getStatus() &&
                Objects.equals(getCreatedDate(), state.getCreatedDate()) &&
                Objects.equals(getModifiedDate(), state.getModifiedDate()) &&
                Objects.equals(getCreatedBy(), state.getCreatedBy()) &&
                Objects.equals(getModifiedBy(), state.getModifiedBy());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getStatus(), getCreatedDate(), getModifiedDate(), getCreatedBy(), getModifiedBy());
    }
}
