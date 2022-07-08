package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.util.validators.SimpleFileValidator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Larbi
 */
@Controller
@RequestMapping("file")
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping("add")
    public String addNewFile(@RequestParam("fileUpload") MultipartFile fileUpload, Model model) {
        var errors = new SimpleFileValidator(fileUpload).validateAll();
        List<String> errorsList = Collections.list(Collections.enumeration(errors.values()));

        if (!errorsList.isEmpty()) {
            
            model.addAttribute("errorsList",errorsList);
            return "result";
        }
        try {
            var file = new File(fileUpload.getOriginalFilename(), fileUpload.getContentType(), String.valueOf(fileUpload.getBytes().length), this.getConnectedUserId(), fileUpload.getBytes());
            var countInsertedFile = fileService.insert(file);
            model.addAttribute("countInsertedFile", countInsertedFile);
        }
        catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String deleteFile(@PathVariable("id") long id, Model model) {
        int countDeletedFile = fileService.delete(id);
        model.addAttribute("countDeletedFile", countDeletedFile);
        return "redirect:/home";
    }

    @GetMapping("view/{id}")
    public void downloadFile(@PathVariable("id") long id, Model model, HttpServletResponse response) throws FileNotFoundException, IOException {
        var file = fileService.find(id);
        response.setContentType(file.getContentType());
        FileCopyUtils.copy(file.getFileData(), response.getOutputStream());
    }

    private long getConnectedUserId() throws UsernameNotFoundException {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)).getUserId();
    }
}
