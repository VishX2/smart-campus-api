package uk.ac.westminster.smartcampus.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/*
 * Catches all unhandled exceptions and prevents stack traces
 * from being exposed to API clients.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {

        // Log internally (console for now)
        exception.printStackTrace();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("An unexpected error occurred. Please try again later.")
                .build();
    }
}