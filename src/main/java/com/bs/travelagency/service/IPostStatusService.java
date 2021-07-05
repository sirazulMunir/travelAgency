package com.bs.travelagency.service;

import com.bs.travelagency.dto.PostStatusDTO;
import com.bs.travelagency.dto.StatusDTO;
import com.bs.travelagency.entity.Status;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IPostStatusService {

    public void save(PostStatusDTO postStatusDTO, HttpServletRequest request);

}
