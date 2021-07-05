package com.bs.travelagency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bs.travelagency")
public class TravelAgencyApplication {

    private static final Logger logger = LogManager.getLogger(TravelAgencyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyApplication.class, args);
    }

}
