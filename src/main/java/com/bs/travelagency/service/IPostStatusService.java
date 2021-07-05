package com.bs.travelagency.service;

import com.bs.travelagency.dto.PostStatusDTO;
import com.bs.travelagency.dto.StatusDTO;
import com.bs.travelagency.entity.Status;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IPostStatusService {

    public void save(PostStatusDTO postStatusDTO, HttpServletRequest request);

    List<StatusDTO> findByUserEmail(String email);

    public Status findById(Long postId);

    public void updatePost(StatusDTO statusDTO, HttpServletRequest request);

    public void updatePrivacy(StatusDTO statusDTO, HttpServletRequest request);

    public List<StatusDTO> getAllPublicPost(HttpServletRequest request);

}
