package com.udacity.jwdnd.course1.cloudstorage.util.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

/**
 * validation source:
 * https://stackoverflow.com/questions/40355743/file-upload-in-spring-boot-uploading-validation-and-exception-handling
 * see also this comment : This can still be bypassed because the content type
 * is from the headers and not the actual file detection itself
 *
 * @author Larbi
 */
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    @Override
    public void initialize(ValidFile constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {

        boolean result = true;

        String contentType = multipartFile.getContentType();
        if (!isSupportedContentType(contentType) && multipartFile.getSize()<2098000) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Only png, jpg, pdf, txt or docx files are allowed. And size below 2MB")
                    .addConstraintViolation();

            result = false;
        }

        return result;
    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("text/plain")
                || contentType.equals("application/pdf")
                || contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
                || contentType.equals("image/jpeg");
    }
}
