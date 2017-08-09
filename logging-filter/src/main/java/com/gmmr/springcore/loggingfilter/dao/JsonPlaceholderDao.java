package com.gmmr.springcore.loggingfilter.dao;

/**
 * Created by Giovanni on 08/08/2017.
 *
 * {@link JsonPlaceholderDao} a sample DAO to obtain data from an external source.
 */
public interface JsonPlaceholderDao {

    /**
     * Obtains users data.
     *
     * @return a string containing the users.
     */
    String getUsers();

}
