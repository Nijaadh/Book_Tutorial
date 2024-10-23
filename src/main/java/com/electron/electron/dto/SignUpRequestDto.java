package com.electron.electron.dto;

public class SignUpRequestDto {
    private String name;
    private String gender;
    private String emailid;
    private String phoneNumber;
    private String password;

    public SignUpRequestDto() {
    }

    public SignUpRequestDto(String name, String gender, String emailid, String phoneNumber, String password) {
        this.name = name;
        this.gender = gender;
        this.emailid = emailid;
        this.phoneNumber = phoneNumber;
        this.password = password;
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
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignUpRequestDto{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", emailid='" + emailid + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
