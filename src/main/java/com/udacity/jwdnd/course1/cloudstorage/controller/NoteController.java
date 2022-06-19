package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Larbi
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    //private final UserMapper userMapper;
    private final NoteService noteService;
    private final CredentialService credentialService;
    private final FileService fileService;

    public NoteController(/*UserMapper userMapper,*/NoteService noteService, CredentialService credentialService, FileService fileService) {
        //this.userMapper = userMapper;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.fileService = fileService;
    }


    @PostMapping("add-or-update")
    public String addNote(@ModelAttribute("note") Note note, Model model) {
        if (note.getNoteId() == null) {
            note.setUserId(2L);
            int countInsertedNote = noteService.insert(note);
            model.addAttribute("countNoteInserted", countInsertedNote);
        } else {
            note.setUserId(2L);
            int countUpdatedNote = noteService.update(note);
            model.addAttribute("countNoteInserted", countUpdatedNote);
        }
        model.addAttribute("note", new Note());

        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String deleteNote(@PathVariable("id") long id, Model model) {
        int countNoteDeleted = noteService.delete(id);
        model.addAttribute("countNoteDeleted", countNoteDeleted);
        return "redirect:/home";
    }

}
