package com.bs.travelagency.beanValidation;

import com.bs.travelagency.entity.User;
import com.bs.travelagency.service.IUserSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserInformationValidation implements Validator {

    @Autowired
    private IUserSetupService userSetupService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        if (userSetupService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
        if (user.getName().length() < 6 || user.getName().length() > 32) {
            errors.rejectValue("name", "userForm.nameSize");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "userForm.passwordSize");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "userForm.passwordConfirm");
        }
    }
}
