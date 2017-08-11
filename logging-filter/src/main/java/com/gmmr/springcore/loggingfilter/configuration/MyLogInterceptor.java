package com.gmmr.springcore.loggingfilter.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Giovanni on 10/08/2017.
 *
 * Sample implementation of a logging filter for the REST template.
 */
public class MyLogInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyLogInterceptor.class);

    /**
     * Will log the request, execute the action and log the response.
     *
     * @param request the HTTP Request object. Note that it's different from the Servlet's
     *                HTTP object.
     * @param body the request's body.
     * @param execution the execution object. This will allow the other interceptors to process
     *                  the request/response and the actual HTTP call.
     * @return the final response object.
     * @throws IOException this is using an HTTP connection, so I/O errors can be expected.
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        logRequest(body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);

        return response;
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        try (BufferedReader reader = getReader(response)) {
            logFromReader(reader);
        }
    }

    private void logRequest(byte[] body) throws IOException {
        try (BufferedReader reader = getReader(body)) {
            logFromReader(reader);
        }
    }

    private void logFromReader(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            LOGGER.info(line);
        }
    }

    private BufferedReader getReader(ClientHttpResponse response) throws IOException {
        return new BufferedReader(new InputStreamReader(response.getBody()));
    }

    private BufferedReader getReader(byte[] body) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(body)));
    }
}
