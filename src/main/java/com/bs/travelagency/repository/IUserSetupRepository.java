package com.bs.travelagency.repository;

import com.bs.travelagency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userSetupRepository")
public interface IUserSetupRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
