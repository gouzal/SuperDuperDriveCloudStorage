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
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        var notes = noteService.findAllByUserId(2);
        model.addAttribute("notes", notes);
        model.addAttribute("note", new Note());
        //load Credentials
        var credentials = this.credentialService.findAllByUserId(2);
        for (int i = 0; i < credentials.size(); i++) {
            Credential c = credentials.get(i);
            var decPass = this.encryptionService.decryptPassword(c.getPassword(), c.getKey());
            c.setPassword(decPass);
        }
        //credentials.forEach((c)->{c.setPassword(this.encryptionService.decryptPassword(c.getPassword(),c.getKey()));});
        model.addAttribute("credentials", credentials);
        model.addAttribute("credential", new Credential());
        //load files
        var files = this.fileService.findAllByUserId(2);
        model.addAttribute("files", files);
        return "home";
    }

    @GetMapping("/login")
    public String displayLogin() {
       /* List<User> findAll = userService.findAll();
        for (int i = 0; i < findAll.size(); i++) {
            User get = findAll.get(i);
            logger.error(get.toString());
            logger.error("username:" + get.getUsername());
            logger.error("password:" + get.getPassword());
            logger.error("salt:" + get.getSalt());
        }*/
        return "login";
    }

    /*@PostMapping("/login")
    public String login() {
        return "login";
    }*/

    @GetMapping("/signup")
    public String displaySignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user, Model model, HashService hashService) {
        var passwordData = this.hashPassword(user, hashService);
        user.setPassword(passwordData.get("hash"));
        user.setSalt(passwordData.get("salt"));
        this.userService.insert(user);
        return "signup";
    }
    
    //todo: move to another location
    private HashMap<String, String> hashPassword(User user, HashService hashService) {
        var passwordData = new HashMap<String, String>();
        byte[] salt = new byte[16];
        java.util.Random random = new java.util.Random();
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        passwordData.put("hash", hashedPassword);
        passwordData.put("salt", encodedSalt);
        return passwordData;
    }
}
