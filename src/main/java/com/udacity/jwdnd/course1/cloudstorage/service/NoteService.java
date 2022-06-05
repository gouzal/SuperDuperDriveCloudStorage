package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public interface NoteService extends AbstractPersistenceService<Note> {

    List<Note> findAllByUserId(long userid);

}
