package com.electron.electron.entity;

import com.electron.electron.common.Constent;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String gender;
    private String emailId;
    private String phoneNumber;
    private String userType = Constent.USER_TYPE.NORMAL;
    private String password;
    private boolean isActive = true;
    private Integer loginCount=0; // Corrected the typo
    private String ssoType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loginAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public User() {
    }

    public User(Long id, String name, String gender, String emailId, String phoneNumber, String userType, String password, boolean isActive, Integer loginCount, String ssoType, Date loginAt, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.password = password;
        this.isActive = isActive;
        this.loginCount = loginCount; // Corrected typo
        this.ssoType = ssoType;
        this.loginAt = loginAt;
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

    public String getEmailid() {
        return emailId;
    }

    public void setEmailid(String emailid) {
        this.emailId = emailid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getLoginCount() { // Corrected typo
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) { // Corrected typo
        this.loginCount = loginCount;
    }

    public String getSsoType() {
        return ssoType;
    }

    public void setSsoType(String ssoType) {
        this.ssoType = ssoType;
    }

    public Date getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", emailid='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", loginCount=" + loginCount +
                ", ssoType='" + ssoType + '\'' +
                ", loginAt=" + loginAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @PrePersist
    public void onCreate() {
        Date currentDateTime = new Date();

        this.createdAt = currentDateTime;
        this.updatedAt = currentDateTime;
    }

    @PostPersist
    public void onUpdate() {
        this.updatedAt = new Date();
    }
}
