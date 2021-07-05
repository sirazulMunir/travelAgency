package com.bs.travelagency.controller;

import com.bs.travelagency.dto.PostStatusDTO;
import com.bs.travelagency.dto.StatusDTO;
import com.bs.travelagency.entity.Location;
import com.bs.travelagency.service.ILocationService;
import com.bs.travelagency.service.IPostStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@PreAuthorize("")
public class PostStatusController {

    //region for private methods
    private static final Logger logger = LogManager.getLogger(PostStatusController.class);

    @Autowired
    private ILocationService locationService;

    @Autowired
    private IPostStatusService postStatusService;
    //endregion

    //region for public methods

    /**
     * After log in redirect to home page
     */
    @GetMapping({"/", "home"})
    public String index(HttpServletRequest request, Model model) {
        logger.info("welcome controller");
        /*List<StatusDTO> statusDTOList = postService.getAllPublicPost(request);
        model.addAttribute("statusList", statusDTOList);*/
        return "home";
    }

    /**
     * Go to the add new post page
     *
     * @param model : Model
     * @return newPost page
     */
    @GetMapping("/postStatus")
    public String newPost(Model model) {
        logger.info("new post controller");
        List<Location> locationList = locationService.getAllLocation();
        model.addAttribute("locationList", locationList);
        return "postStatus";
    }


    /**
     * Save a new post
     *
     * @param postStatusDTO : PostStatusDTO
     * @param request       : HttpServletRequest
     * @param model         : Model
     */
    @PostMapping(value = "/postStatus")
    public String newPostSave(PostStatusDTO postStatusDTO, HttpServletRequest request, Model model) {
        boolean isValid = true;
        if (postStatusDTO.getPost() == null || "".equals(postStatusDTO.getPost())) {
            model.addAttribute("nullPost", "Post is empty");
            isValid = false;
        }

        if (postStatusDTO.getLocation() == null) {
            model.addAttribute("nullLocation", "Location is empty");
            isValid = false;
        }

        if (postStatusDTO.getPostPrivacy() == null) {
            model.addAttribute("nullPrivacy", "Privacy is empty");
            isValid = false;
        }

        if (isValid) {
            postStatusService.save(postStatusDTO, request);
            logger.info("Post successfully saved");
            return "redirect:/home";
        }

        return "postStatus";
    }

    //endregion
}
