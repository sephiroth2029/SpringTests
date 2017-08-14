package com.gmmr.springcore.loggingfilter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Giovanni on 08/08/2017.
 *
 * The REST implementation of the DAO. This is designed to be very simple as the REST service
 * consumption is not of interest.
 */
@Repository
public class JsonPlaceholderDaoImpl implements JsonPlaceholderDao {

    private RestTemplate restTemplate;

    private String serviceUrl;

    /**
     * Dependencies constructor.
     *
     * @param restTemplate the {@link RestTemplate} to be used by this DAO.
     * @param serviceUrl the complete service URL to be consumed.
     */
    public JsonPlaceholderDaoImpl(@Autowired RestTemplate restTemplate,
                                  @Value("${external.serviceUrl}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
    }

    /**
     * Obtains the JSON String representation of the users.
     *
     * @return the JSON String representation of the users.
     */
    @Override
    public String getUsers() {
        return restTemplate.getForObject(serviceUrl, String.class);
    }
}
