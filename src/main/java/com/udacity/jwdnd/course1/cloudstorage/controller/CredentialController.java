package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import java.util.Map;
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
@RequestMapping("/credential")
public class CredentialController {

    private final CredentialService credentialService;
    private final EncryptionService encryptionService;
    private final UserService userService;

    public CredentialController(CredentialService credentialService, EncryptionService encryptionService, UserService userService) {
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
        this.userService = userService;
    }

    @PostMapping("add-or-update")
    public String addCredential(@ModelAttribute("credential") Credential credential, Model model) {
        Map encryptData = this.encryptionService.encryptPassword(credential.getPassword());
        credential.setPassword(encryptData.get("encryptPassword").toString());
        credential.setKey(encryptData.get("encodedKey").toString());
        credential.setUserId(getConnectedUserId());
        if (credential.getCredentialId() == null) {
            int countInsertedCredential = credentialService.insert(credential);
            model.addAttribute("countInsertedCredential", countInsertedCredential);
        } else {
            int countUpdatedCredential = credentialService.update(credential);
            model.addAttribute("countUpdatedCredential", countUpdatedCredential);
        }
        model.addAttribute("credential", new Credential());

        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String deleteCredential(@PathVariable("id") long id, Model model) {
        int countDeletedCredential = credentialService.delete(id);
        model.addAttribute("countDeletedCredential", countDeletedCredential);
        return "redirect:/home";
    }

    private long getConnectedUserId() throws UsernameNotFoundException {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)).getUserId();
    }
}
