package com.example.myapplication16;

public class User {

    private int Id;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Password;
    private String Country;
    private String City;
    private String PhoneNum;

    private String EmailAddress;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public User() {
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public User(int id, String firstName, String lastName, String gender, String password, String country, String city, String phoneNum, String emailAddress) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        Password = password;
        Country = country;
        City = city;
        PhoneNum = phoneNum;
        EmailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Password='" + Password + '\'' +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", PhoneNum='" + PhoneNum + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                '}';
    }
}
