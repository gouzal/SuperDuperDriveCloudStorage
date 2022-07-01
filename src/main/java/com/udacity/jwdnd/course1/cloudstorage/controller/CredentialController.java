package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.EncryptionService;
import java.util.Map;
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

    public CredentialController(CredentialService credentialService, EncryptionService encryptionService) {
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
    }

    @PostMapping("add-or-update")
    public String addCredential(@ModelAttribute("credential") Credential credential, Model model) {
        Map encryptData = this.encryptionService.encryptPassword(credential.getPassword());
        credential.setPassword(encryptData.get("encryptPassword").toString());
        credential.setKey(encryptData.get("encodedKey").toString());
        credential.setUserId(2L);
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

}
