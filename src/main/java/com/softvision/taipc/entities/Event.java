package com.softvision.taipc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "event")
public class Event {

    @Id
    private String id;
    private String eventkey;
    private String eventValue;
    private String createdBy;
    private LocalDateTime creationTime;
    private LocalDateTime modifiedTime;


    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventkey() {
        return eventkey;
    }

    public void setEventkey(String eventkey) {
        this.eventkey = eventkey;
    }

    public String getEventValue() {
        return eventValue;
    }

    public void setEventValue(String eventValue) {
        this.eventValue = eventValue;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(getId(), event.getId()) &&
                Objects.equals(getEventkey(), event.getEventkey()) &&
                Objects.equals(getEventValue(), event.getEventValue()) &&
                Objects.equals(getCreatedBy(), event.getCreatedBy()) &&
                Objects.equals(getCreationTime(), event.getCreationTime()) &&
                Objects.equals(getModifiedTime(), event.getModifiedTime());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEventkey(), getEventValue(), getCreatedBy(), getCreationTime(), getModifiedTime());
    }
}
