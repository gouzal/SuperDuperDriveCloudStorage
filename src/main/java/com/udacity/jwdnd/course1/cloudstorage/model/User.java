package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Objects;

public class User {
    private long userId;
    private String username;
    private String salt;
    private String password; //todo : convert to char
    private String firstname;
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
