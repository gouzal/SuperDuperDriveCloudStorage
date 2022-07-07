package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private long userId;
    @NotBlank
    @Size(min = 6, max = 30)
    private String username;
    private String salt;
    @NotBlank
    //pattern source from : https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$", message = "Password must contain at least one digit [0-9] Password must contain at least one lowercase Latin character [a-z], must contain at least one uppercase Latin character [A-Z], must contain at least one special character like ! @ # & ( ),and  must contain a length of at least 8 characters and a maximum of 20 characters.")
    private String password; //todo : convert to char
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstname;
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastname;

    public User() {
    }

    public User(long userId, String username, String salt, String password, String firstname, String lastname) {
        this.userId = userId;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.salt);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.firstname);
        hash = 59 * hash + Objects.hashCode(this.lastname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.getUserId()) {
            return false;
        }
        if (!Objects.equals(this.username, other.getUsername())) {
            return false;
        }
        return Objects.equals(this.salt, other.getSalt());
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userId + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }

}
