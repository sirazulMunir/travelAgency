package com.bs.travelagency.service;

import com.bs.travelagency.entity.User;

public interface IUserSetupService {

    public void save(User user);

    public User findByEmail(String email);

}
