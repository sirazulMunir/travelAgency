package com.bs.travelagency.serviceImpl;

import com.bs.travelagency.entity.Location;
import com.bs.travelagency.repository.ILocationRepository;
import com.bs.travelagency.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements ILocationService {

    //region for private methods
    @Autowired
    @Qualifier(value = "locationRepository")
    private ILocationRepository locationRepository;
    //endregion

    //region for public methods

    /**
     * Find all location info
     */
    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    /**
     * Find location by location ID
     *
     * @param locationId : Long
     */
    @Override
    public Optional<Location> getLocationById(Long locationId) {
        return locationRepository.findById(locationId);
    }
    //endregion
}
