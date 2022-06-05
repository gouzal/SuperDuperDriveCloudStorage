package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.HashService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public MainController(UserService userService, NoteService noteService, CredentialService credentialService, FileService fileService) {
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.fileService = fileService;
    }

    @GetMapping("/home")
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

    @GetMapping("/login")
    public String displayLogin() {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        userService.findAll().forEach(u -> {
            logger.debug(u.toString());
        });
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "login";
    }

    @PostMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/signup")
    public String displaySignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user, Model model, HashService hashService) {
        user.setSalt(this.hashPassword(user, hashService));
        this.userService.insert(user);
        return "signup";
    }

    private String hashPassword(User user,HashService hashService) {
        byte[] salt = new byte[16];
        java.util.Random random=new java.util.Random();
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return hashedPassword;
    }
}
