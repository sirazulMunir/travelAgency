package com.bs.travelagency.controller;

import com.bs.travelagency.dto.PostStatusDTO;
import com.bs.travelagency.dto.StatusDTO;
import com.bs.travelagency.entity.Location;
import com.bs.travelagency.entity.Status;
import com.bs.travelagency.service.ILocationService;
import com.bs.travelagency.service.IPostStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     *
     * @param model : Model
     */
    @GetMapping({"/", "home"})
    public String index(HttpServletRequest request, Model model) {
        logger.info("welcome controller");
        List<StatusDTO> statusDTOList = postStatusService.getAllPublicPost(request);
        model.addAttribute("statusList", statusDTOList);
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
        logger.info("Post a status");
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

    /**
     * Get all personal post by email address
     *
     * @param model   : Model
     * @param request : HttpServletRequest
     * @return List<StatusDTO>
     */
    @GetMapping(value = "/personalPosts")
    public String getPersonalPost(Model model, HttpServletRequest request) {
        logger.info("Get personal posts");
        List<StatusDTO> statusDTOList = postStatusService.findByUserEmail(request.getUserPrincipal().getName());
        model.addAttribute("personalPostList", statusDTOList);
        return "personalPosts";
    }

    /**
     * Get Post information by postID
     *
     * @param postId : Long
     * @param model  : Model
     */
    @GetMapping(value = "/editPost/{postId}")
    public String editPost(@PathVariable Long postId, Model model) {
        logger.info("Edit personal posts");
        Status status = postStatusService.findById(postId);
        model.addAttribute("postId", status.getId());
        model.addAttribute("post", status.getPost());
        return "editPost";
    }

    /**
     * Update post information
     *
     * @param statusDTO : StatusDTO
     * @param request   : HttpServletRequest
     * @param model     : Model
     */
    @PostMapping(value = "/updatePost")
    public String updatePost(StatusDTO statusDTO, HttpServletRequest request, Model model) {
        logger.info("Edit personal posts");
        boolean isValid = true;
        if (statusDTO.getPost() == null || "".equals(statusDTO.getPost())) {
            isValid = false;
            model.addAttribute("error", "Post can not be empty");
        }
        if (isValid) {
            postStatusService.updatePost(statusDTO, request);
            logger.info("Post successfully updated");
            return "redirect:/personalPosts";
        }
        model.addAttribute("postId", statusDTO.getPostId());
        return "editPost";
    }

    /**
     * Get post privacy by postId
     *
     * @param postId : Long
     * @param model  : Model
     */
    @GetMapping(value = "/changePrivacy/{postId}")
    public String changePrivacy(@PathVariable Long postId, Model model) {
        logger.info("Get post privacy");
        Status status = postStatusService.findById(postId);
        model.addAttribute("postId", status.getId());
        model.addAttribute("post", status.getPost());
        model.addAttribute("privacy", status.getPostPrivacy());
        return "changePrivacy";
    }


    /**
     * Update post privacy
     *
     * @param statusDTO : StatusDTO
     *                  5z6
     */
    @PostMapping(value = "/updatePrivacy")
    public String updatePrivacy(StatusDTO statusDTO, HttpServletRequest request, Model model) {
        logger.info("Edit post privacy");
        boolean isValid = true;
        if (statusDTO.getPostPrivacy() == -1) {
            isValid = false;
            model.addAttribute("error", "Privacy must be selected");
        }

        if (isValid) {
            postStatusService.updatePrivacy(statusDTO, request);
            logger.info("Post privacy successfully updated");
            return "redirect:/personalPosts";
        }

        model.addAttribute("postId", statusDTO.getPostId());
        return "changePrivacy";
    }
    //endregion
}
