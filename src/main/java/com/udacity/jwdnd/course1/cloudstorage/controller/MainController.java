package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.HashService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Larbi
 */
@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(HashService.class);

    private final UserService userService;
    private final NoteService noteService;
    private final CredentialService credentialService;
    private final FileService fileService;
    private final EncryptionService encryptionService;

    public MainController(UserService userService, NoteService noteService, CredentialService credentialService, FileService fileService, EncryptionService encryptionService) {
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.fileService = fileService;
        this.encryptionService = encryptionService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        //load notes
        var notes = noteService.findAllByUserId(this.getConnectedUserId());
        model.addAttribute("notes", notes);
        model.addAttribute("note", new Note());
        //load Credentials
        var credentials = this.credentialService.findAllByUserId(this.getConnectedUserId());
        for (int i = 0; i < credentials.size(); i++) {
            Credential c = credentials.get(i);
            var decPass = this.encryptionService.decryptPassword(c.getPassword(), c.getKey());
            c.setPassword(decPass);
        }
        model.addAttribute("credentials", credentials);
        model.addAttribute("credential", new Credential());
        //load files
        var files = this.fileService.findAllByUserId(this.getConnectedUserId());
        model.addAttribute("files", files);
        return "home";
    }

    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @GetMapping("/signup")
    public String displaySignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HashService hashService) {
        if (bindingResult.hasErrors()) {
            if (this.userService.findByUsername(user.getUsername()).isPresent()) {
                bindingResult.addError(new FieldError("user", "username", "username is already exists"));
            }
            return "signup";
        }

        var passwordData = this.encryptionService.hashPassword(user.getPassword(), hashService);
        user.setPassword(passwordData.get("hash"));
        user.setSalt(passwordData.get("salt"));
        int insert = this.userService.insert(user);
        model.addAttribute("signup", insert);
        return "signup";
    }

    private long getConnectedUserId() throws UsernameNotFoundException {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)).getUserId();
    }
}
