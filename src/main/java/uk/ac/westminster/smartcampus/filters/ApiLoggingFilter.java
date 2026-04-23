package uk.ac.westminster.smartcampus.filters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.logging.Logger;

/*
 * Logs all incoming requests and outgoing responses.
 * Helps with debugging and monitoring API behavior.
 */
@Provider
public class ApiLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger logger = Logger.getLogger(ApiLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        logger.info("Request: " +
                requestContext.getMethod() + " " +
                requestContext.getUriInfo().getRequestUri());
    }

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        logger.info("Response Status: " + responseContext.getStatus());
    }
}