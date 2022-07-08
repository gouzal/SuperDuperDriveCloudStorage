
package com.udacity.jwdnd.course1.cloudstorage.util.validators;

/**
 *
 * @author Larbi
 */
public class ViolationErrors {
    private final String fieldName;
  private final String message;
  public ViolationErrors(String fieldName, String message) {
    this.fieldName = fieldName;
    this.message = message;
  }
  public String getFieldName() {
    return fieldName;
  }
  public String getMessage() {
    return message;
  }
}
