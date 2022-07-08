package com.udacity.jwdnd.course1.cloudstorage.util.validators;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larbi
 */
public class ValidationFailedResponse {

    private List<ViolationErrors> violations = new ArrayList<>();

    public List<ViolationErrors> getViolations() {
        return violations;
    }

    public void setViolations(List<ViolationErrors> violations) {
        this.violations = violations;
    }
}
