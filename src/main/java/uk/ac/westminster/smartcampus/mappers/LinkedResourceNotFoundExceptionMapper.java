package uk.ac.westminster.smartcampus.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import uk.ac.westminster.smartcampus.exceptions.LinkedResourceNotFoundException;

/*
 * Maps LinkedResourceNotFoundException to HTTP 422 response.
 */
@Provider
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<LinkedResourceNotFoundException> {

    @Override
    public Response toResponse(LinkedResourceNotFoundException exception) {
        return Response.status(422)
                .entity(exception.getMessage())
                .build();
    }
}