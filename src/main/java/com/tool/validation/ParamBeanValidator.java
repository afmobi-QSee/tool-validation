package com.tool.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by liang on 18-4-17.
 */
public class ParamBeanValidator {

    private static Logger logger = LoggerFactory.getLogger(ParamBeanValidator.class);
    private static ValidatorFactory vf = Validation.buildDefaultValidatorFactory();

    /**
     * 是正确：验证通过时返回true
     * @param bean
     * @param classes
     * @return
     */
    public static boolean isValid(Object bean, Class... classes) {

        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> constraintViolationResult = validator.validate(bean, classes);
        if (constraintViolationResult.isEmpty()) {
            return true;
        } else {
            for(ConstraintViolation<Object> item : constraintViolationResult) {
                logger.info("[参数错误] " + item.getPropertyPath() + ": " + item.getMessage());
            }
            return false;
        }
    }

    /**
     * 是不正确：验证不通过时返回true
     * @param bean
     * @param classes
     * @return
     */
    public static boolean isNotValid(Object bean, Class... classes) {
        return !isValid(bean, classes);
    }

    /**
     * 校验参数是否有效，如果有问题返回对应错误
     * @param bean
     * @param classes
     * @return
     */
    public static ValidationResult valid(Object bean, Class... classes) {

        ValidationResult result = new ValidationResult();

        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> constraintViolationResult = validator.validate(bean, classes);
        if (constraintViolationResult.isEmpty()) {
            result.setValid(true);
        } else {
            result.setValid(false);
            List<ValidationResultsException> validationResultsExceptions = new ArrayList<>();
            for(ConstraintViolation<Object> item : constraintViolationResult) {
                logger.info("[参数错误] " + item.getPropertyPath() + ": " + item.getMessage());
                ValidationResultsException validationResultsException = new ValidationResultsException(item.getPropertyPath().toString(), item.getMessage());
                validationResultsExceptions.add(validationResultsException);
            }
            result.setValidationResultsExceptions(validationResultsExceptions);
        }

        return result;
    }

}
