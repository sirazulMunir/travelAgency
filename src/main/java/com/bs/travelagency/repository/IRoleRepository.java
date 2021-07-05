package com.bs.travelagency.repository;

import com.bs.travelagency.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
