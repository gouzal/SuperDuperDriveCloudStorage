package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Objects;

/**
 *
 * @author Larbi
 */
public class Credential {
    private Long credentialId;
    private String url;
    private String userName;
    private String key;
    private String password;
    private Long userId;

    public Credential() {
    }

    
    public Credential(Long credentialId, String url, String userName, String key, String password, Long userId) {
        this.credentialId = credentialId;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.password = password;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.url);
        hash = 71 * hash + Objects.hashCode(this.userName);
        hash = 71 * hash + Objects.hashCode(this.key);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + (int) (this.userId ^ (this.userId >>> 32));
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
        final Credential other = (Credential) obj;
        if (this.userId != other.getUserId()) {
            return false;
        }
        if (!Objects.equals(this.url, other.getUrl())) {
            return false;
        }
        if (!Objects.equals(this.userName, other.getUserName())) {
            return false;
        }
        if (!Objects.equals(this.key, other.getKey())) {
            return false;
        }
        return Objects.equals(this.password, other.getPassword());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Credential{");
        sb.append("credentialId=").append(credentialId);
        sb.append(", url=").append(url);
        sb.append(", userName=").append(userName);
        sb.append(", key=").append(key);
        sb.append(", password=").append(password);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
