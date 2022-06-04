package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Objects;

public class File {

    private long fileId;
    private String fileName;
    private String contentType;
    private String fileSize;
    private long userId;
    private byte[] fileData;

    public File() {
    }

    public File(long id, String name, String contentType, String size, long userId, byte[] data) {
        this.fileId = id;
        this.fileName = name;
        this.contentType = contentType;
        this.fileSize = size;
        this.userId = userId;
        this.fileData = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.fileName);
        hash = 53 * hash + Objects.hashCode(this.contentType);
        hash = 53 * hash + Objects.hashCode(this.fileSize);
        hash = 53 * hash + Objects.hashCode(this.fileData);
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
        final File other = (File) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.contentType, other.contentType)) {
            return false;
        }
        if (!Objects.equals(this.fileSize, other.fileSize)) {
            return false;
        }
        return Objects.equals(this.fileData, other.fileData);
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public byte[] getFileData() {
        return this.fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("File{");
        sb.append("id=").append(fileId);
        sb.append(", name=").append(fileName);
        sb.append(", contentType=").append(contentType);
        sb.append(", size=").append(fileSize);
        sb.append(", userId=").append(userId);
        sb.append(", data=").append(fileData);
        sb.append('}');
        return sb.toString();
    }

}
