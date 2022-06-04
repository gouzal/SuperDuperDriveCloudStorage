package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Objects;

public class Note {

    private Long noteId;
    private String noteTitle;
    private String noteDescription;
    private Long userId;

    public Note() {
    }

    public Note(Long noteId, String noteTitle, String noteDescription, Long userId) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.userId = userId;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.noteTitle);
        hash = 13 * hash + Objects.hashCode(this.noteDescription);
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
        final Note other = (Note) obj;
        if (this.noteId != other.getNoteId()) {
            return false;
        }
        if (this.userId != other.getUserId()) {
            return false;
        }
        if (!Objects.equals(this.noteTitle, other.getNoteTitle())) {
            return false;
        }
        return Objects.equals(this.noteDescription, other.getNoteDescription());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Note{");
        sb.append("noteId=").append(noteId);
        sb.append(", noteTitle=").append(noteTitle);
        sb.append(", noteDescription=").append(noteDescription);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }

}
