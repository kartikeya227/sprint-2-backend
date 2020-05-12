package org.com.model;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;//auto generated, not to be taken as input by user.

    @Column(name = "userType", nullable = false)
    @NotNull(message = "User type can't be blank, choose either 'Customer' or 'Admin'.")
    private String userType;

    @Column(name = "userName", nullable = false, unique = true)
    @NotNull(message = "User name can't be empty")
    private String userName;

    @Column(name = "userPassword", nullable = false)
    @NotNull(message = "User password can't be empty")
    private String userPassword;

    @Column(name = "userPhone", nullable = false, unique = true)
    @NotNull(message = "User phone number can't be empty")
    private String userPhone;

    @Column(name = "userEmail", nullable = false, unique = true)
    @NotNull(message = "User userEmail can't be empty")
    private String userEmail;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "users{" +
                "userId=" + userId +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
