package com.udacity.jwdnd.course1.cloudstorage.util.validators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Larbi
 */
public class SimpleFileValidator {

    private final long MAX_SIZE = 3000000;
    protected final String MAX_SIZE_ERROR_MESSAGE = "Max size is 3MB";
    private final String[] SUPPORTED_CONTENT_TYPE = {"image/png", "image/jpg", "text/plain", "application/pdf", "image/jpeg", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"};
    protected final String SUPPORTED_CONTENT_TYPE_ERROR_MESSAGE = "Only png, jpg, pdf, txt or docx files are allowed.";
    private final MultipartFile file;

    public SimpleFileValidator(MultipartFile file) {
        this.file = file;
    }

    protected boolean checkSize() {
        return file.getSize() < MAX_SIZE;
    }

    protected boolean isSupportedContentType() {
        return Arrays.stream(SUPPORTED_CONTENT_TYPE).anyMatch(file.getContentType()::equals);
    }

    public Map<String, String> validateAll() {
        var errors = new HashMap<String, String>();
        if (!checkSize()) {
            errors.put("FileSize", MAX_SIZE_ERROR_MESSAGE);
        }
        if (!isSupportedContentType()) {
            errors.put("FileType", SUPPORTED_CONTENT_TYPE_ERROR_MESSAGE);
        }
        return errors;
    }
}
