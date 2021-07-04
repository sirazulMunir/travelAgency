package com.bs.travelagency.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@PreAuthorize("")
public class PostStatusController {

    @GetMapping({"/", "home"})
    public String index(HttpServletRequest request, Model model) {
        return "home";
    }
}
