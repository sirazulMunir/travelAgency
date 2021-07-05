package com.bs.travelagency.service;

import com.bs.travelagency.entity.Location;

import java.util.List;
import java.util.Optional;

public interface ILocationService {

    public List<Location> getAllLocation();

    public Optional<Location> getLocationById(Long locationId);
}
