package com.electron.electron.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.Type;
//import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gender;
//    @Type(type="org.jadira.usertype.dateandtime.joda.persistentDateTime")
//    private DateTime createdAt;
    private Date createdAt;
//    @Type(type="org.jadira.usertype.dateandtime.joda.persistentDateTime")
//    private DateTime updatedAt;
    private Date updatedAt;

    public Author() {
    }

    public Author(Long id, String name, String gender, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
