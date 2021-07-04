package com.bs.travelagency.controller;

import com.bs.travelagency.beanValidation.UserInformationValidation;
import com.bs.travelagency.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("")
public class UserController {

    //region for private methods
    @Autowired
    private UserInformationValidation userInformationValidation;
    //endregion

    /**
     * Redirect to login
     *
     * */
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    /**
     * Redirect to registration page
     * @param model : Model
     * */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "userRegistration";
    }

    /**
     * Save user Information
     *
     * @param user          : User
     * @param bindingResult : BindingResult
     * @return if Save information success then login page else userRegistration page
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
        userInformationValidation.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "userRegistration";
        }
        return "redirect:/login";
    }
}
