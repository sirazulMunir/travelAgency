package com.bs.travelagency.repository;

import com.bs.travelagency.entity.Status;
import com.bs.travelagency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "postStatusRepository")
public interface IPostStatusRepository extends JpaRepository<Status, Integer> {

    List<Status> findByUserEmail(String email);

    @Query(value = "SELECT u FROM Status u WHERE u.postPrivacy = 0 AND u.user = :user")
    List<Status> findByUserWithPrivate(@Param("user") User user);

    @Query(value = "SELECT u FROM Status u WHERE u.postPrivacy = 1")
    List<Status> getAllPublicPost();
}
