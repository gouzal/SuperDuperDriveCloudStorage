package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @PostMapping("add-or-update")
    public String addNote(@ModelAttribute("note") Note note, Model model) {
        if (note.getNoteId() == null) {
            note.setUserId(getConnectedUserId());
            int countInsertedNote = noteService.insert(note);
            model.addAttribute("countNoteInserted", countInsertedNote);
        } else {
            note.setUserId(getConnectedUserId());
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

    private long getConnectedUserId() throws UsernameNotFoundException {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)).getUserId();
    }
}
