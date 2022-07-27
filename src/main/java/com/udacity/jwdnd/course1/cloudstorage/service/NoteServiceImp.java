package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public class NoteServiceImp implements NoteService {

    private final NoteMapper noteMapper;

    public NoteServiceImp(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @Override
    public Note find(long noteId) {
        var note = this.noteMapper.find(noteId);
        if (note == null) {
            throw new IllegalArgumentException("Invalid note Id:" + noteId);
        }
        return note;
    }

    @Override
    public List<Note> findAllByUserId(long userid) {
        return this.noteMapper.findAllByUserId(userid);
    }

    @Override
    public int insert(Note note) {
        return this.noteMapper.insert(note);
    }

    @Override
    public int delete(long noteId) {
        var note = this.find(noteId);
        return this.noteMapper.delete(note.getNoteId());
    }

    @Override
    public int update(Note note) {
        return this.noteMapper.update(note);
    }

    @Override
    public List<Note> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
