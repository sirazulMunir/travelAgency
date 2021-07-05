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

}
