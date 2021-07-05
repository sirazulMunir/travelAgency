package com.bs.travelagency.serviceImpl;

import com.bs.travelagency.dto.PostStatusDTO;
import com.bs.travelagency.dto.StatusDTO;
import com.bs.travelagency.entity.Location;
import com.bs.travelagency.entity.Status;
import com.bs.travelagency.entity.User;
import com.bs.travelagency.repository.IPostStatusRepository;
import com.bs.travelagency.service.IPostStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostStatusService implements IPostStatusService {

    //region for private methods
    @Autowired
    @Qualifier(value = "postStatusRepository")
    private IPostStatusRepository postStatusRepository;

    @Autowired
    private UserSetupService userSetupService;

    @Autowired
    private LocationService locationService;
    //endregion


    //region for public methods

    /**
     * Save post information
     *
     * @param postStatusDTO : PostStatusDTO
     * @param request       : HttpServletRequest
     */
    @Override
    public void save(PostStatusDTO postStatusDTO, HttpServletRequest request) {
        User user = userSetupService.findByEmail(request.getUserPrincipal().getName());
        Location location = locationService.getLocationById(postStatusDTO.getLocation()).get();

        Status status = new Status();
        status.setPost(postStatusDTO.getPost());
        status.setLocation(location);
        status.setUser(user);
        status.setPostPrivacy(postStatusDTO.getPostPrivacy());

        postStatusRepository.saveAndFlush(status);
    }

    /**
     * Get post information by postID
     *
     * @param postId : Long
     * @return Status entity
     */
    @Override
    public Status findById(int postId) {
        return postStatusRepository.findById(postId).get();
    }

    /**
     * Update post information
     *
     * @param statusDTO : StatusDTO
     * @param request   : HttpServletRequest
     */
    @Override
    public void updatePost(StatusDTO statusDTO, HttpServletRequest request) {
        Status status = findById(statusDTO.getPostId());
        if (status != null) {
            status.setPost(statusDTO.getPost());
            if (request.getUserPrincipal().getName().equals(status.getUser().getEmail())) {
                postStatusRepository.saveAndFlush(status);
            }
        }
    }

    /**
     * Update post privacy
     *
     * @param statusDTO : StatusDTO
     * @param request   : request
     */
    @Override
    public void updatePrivacy(StatusDTO statusDTO, HttpServletRequest request) {
        Status status = findById(statusDTO.getPostId());
        if (status != null) {
            status.setPostPrivacy(statusDTO.getPostPrivacy());
            if (request.getUserPrincipal().getName().equals(status.getUser().getEmail())) {
                postStatusRepository.saveAndFlush(status);
            }
        }
    }

    /**
     * Get all public post
     *
     * @param request : HttpServletRequest
     * @return List<StatusDTO>
     */
    @Override
    public List<StatusDTO> getAllPublicPost(HttpServletRequest request) {
        User user = userSetupService.findByEmail(request.getUserPrincipal().getName());
        List<Status> userSpecificStatusList = postStatusRepository.findByUserWithPrivate(user);
        List<Status> publicStatusList = postStatusRepository.getAllPublicPost();


        publicStatusList.addAll(userSpecificStatusList);
        List<StatusDTO> statusDTOList = new ArrayList<StatusDTO>();

        for (Status status : publicStatusList) {
            if (status.getPostPrivacy() == 1) {
                StatusDTO statusDTO = new StatusDTO();
                statusDTO.setLocation(status.getLocation().getLocation());
                statusDTO.setPost(status.getPost());
                statusDTO.setPostId(status.getId());
                statusDTO.setUserName(status.getUser().getName());
                statusDTO.setPostPrivacy(status.getPostPrivacy());
                statusDTO.setPostDate(status.getPostDate());

                statusDTOList.add(statusDTO);
            }
        }

        return statusDTOList;
    }

    /**
     * Get all personal post by email address
     *
     * @param email : String
     * @return List<StatusDTO>
     */
    @Override
    public List<StatusDTO> findByUserEmail(String email) {
        List<Status> statusList = postStatusRepository.findByUserEmail(email);
        List<StatusDTO> statusDTOList = new ArrayList<StatusDTO>();

        for (Status status : statusList) {
            statusDTOList.add(new StatusDTO(status.getId(), status.getPost(), status.getLocation().getLocation(), status.getPostPrivacy(), status.getPostDate()));
        }

        return statusDTOList;
    }
    //endregion

}
