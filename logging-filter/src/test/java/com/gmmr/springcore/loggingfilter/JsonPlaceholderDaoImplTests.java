package com.gmmr.springcore.loggingfilter;

import com.gmmr.springcore.loggingfilter.dao.JsonPlaceholderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

/**
 * Simple test to start the REST call.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonPlaceholderDaoImplTests {

    @Autowired
    private JsonPlaceholderDao jsonPlaceholderDao;

	@Test
	public void whenGetUsersThenNonEmptyStringShouldBeReturned() {
	    String users = jsonPlaceholderDao.getUsers();
        assertThat(users, not(isEmptyString()));
	}

}
