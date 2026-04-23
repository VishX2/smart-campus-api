package uk.ac.westminster.smartcampus.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import uk.ac.westminster.smartcampus.exceptions.RoomNotEmptyException;

/*
 * Maps RoomNotEmptyException to HTTP 409 Conflict response.
 */
@Provider
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {

    @Override
    public Response toResponse(RoomNotEmptyException exception) {
        return Response.status(Response.Status.CONFLICT)
                .entity(exception.getMessage())
                .build();
    }
}