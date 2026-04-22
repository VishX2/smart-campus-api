package uk.ac.westminster.smartcampus.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import uk.ac.westminster.smartcampus.models.Room;
import uk.ac.westminster.smartcampus.storage.DataStore;

import java.util.Collection;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    // GET /api/v1/rooms
    @GET
    public Collection<Room> getAllRooms() {
        return DataStore.rooms.values();
    }

    // POST /api/v1/rooms
    @POST
    public Response createRoom(Room room) {

        if (room.getId() == null || room.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Room ID is required")
                    .build();
        }

        DataStore.rooms.put(room.getId(), room);

        return Response.status(Response.Status.CREATED)
                .entity(room)
                .build();
    }
}