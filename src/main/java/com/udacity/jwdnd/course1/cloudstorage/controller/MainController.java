package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Larbi
 */
@Controller
@RequestMapping("/home")
public class MainController {

    //private final UserMapper userMapper;
    private final NoteService noteService;
    private final CredentialService credentialService;
    private final FileService fileService;

    public MainController(/*UserMapper userMapper,*/NoteService noteService, CredentialService credentialService, FileService fileService) {
        //this.userMapper = userMapper;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.fileService = fileService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        //load notes
        var notes = noteService.findAllByUserId(2);
        model.addAttribute("notes", notes);
        model.addAttribute("note", new Note());
        //load Credentials
        var credentials = this.credentialService.findAllByUserId(2);
        model.addAttribute("credentials", credentials);
        model.addAttribute("credential", new Credential());
        //load files
        var files = this.fileService.findAllByUserId(2);
        model.addAttribute("files", files);
        return "home";
    }


}
