package com.bs.travelagency.serviceImpl;

import com.bs.travelagency.entity.Role;
import com.bs.travelagency.entity.User;
import com.bs.travelagency.repository.IUserSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetails")
public class UserDetailsServiceImpl implements UserDetailsService {

    //region for private methods
    @Autowired
    @Qualifier(value = "userSetupRepository")
    private IUserSetupRepository userSetupRepository;
    //endregion

    //region for public methods
    /**
     * Get user details by user email
     *
     * @param email : String
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userSetupRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
    //endregion
}
