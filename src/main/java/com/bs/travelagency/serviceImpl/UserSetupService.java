package com.bs.travelagency.serviceImpl;

import com.bs.travelagency.entity.User;
import com.bs.travelagency.repository.IUserSetupRepository;
import com.bs.travelagency.service.IUserSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSetupService implements IUserSetupService {

    //region for private methods
    @Autowired
    @Qualifier(value = "userSetupRepository")
    private IUserSetupRepository userSetupRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //region for public methods

    /**
     * Save user Information User
     *
     * @param user : User
     */
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userSetupRepository.saveAndFlush(user);
    }

    /**
     * Find user Information by Email
     *
     * @param email : String
     */
    @Override
    public User findByEmail(String email) {
        return userSetupRepository.findByEmail(email);
    }
    //endregion
}
