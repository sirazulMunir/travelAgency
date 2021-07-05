package com.bs.travelagency.repository;

import com.bs.travelagency.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "locationRepository")
public interface ILocationRepository extends JpaRepository<Location, Long> {
}
