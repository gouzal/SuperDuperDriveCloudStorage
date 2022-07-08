
package com.udacity.jwdnd.course1.cloudstorage.util.validators;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * validation source: https://stackoverflow.com/questions/40355743/file-upload-in-spring-boot-uploading-validation-and-exception-handling
 * see also this comment : This can still be bypassed because the content type is from the headers and not the actual file detection itself
 * @author Larbi
 */
//@Target(ElementType.PARAMETER)
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {FileValidator.class})
public @interface ValidFile {
    String message() default "Only png, jpg, pdf, txt or docx files are allowed. And size below 2MB";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}