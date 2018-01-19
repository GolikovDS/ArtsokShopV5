package ru.artsok.dao.entitys;


import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class User {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String middleName;
    @NotNull
    private String phone;
    @NotNull
    @Email
    private String username;
    @NotNull
    private String company;
    @NotNull
    @Size(min = 3)
    private String password;

    public User(String company, String email, String firstName, String lastName, String middleName, String phone, String password) {

        this.company = company;
        this.username = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.password = password;
    }

    public User() {
    }

    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
