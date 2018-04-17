package com.tool.validation;

import java.util.List;

/**
 * Created by liang on 18-4-17.
 */
public class ValidationResult {
    private boolean valid; //是否有效

    private List<ValidationResultsException> validationResultsExceptions; //验证无效字段列表

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<ValidationResultsException> getValidationResultsExceptions() {
        return validationResultsExceptions;
    }

    public void setValidationResultsExceptions(List<ValidationResultsException> validationResultsExceptions) {
        this.validationResultsExceptions = validationResultsExceptions;
    }

}
