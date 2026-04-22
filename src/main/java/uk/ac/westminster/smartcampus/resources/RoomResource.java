package uk.ac.westminster.smartcampus.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import uk.ac.westminster.smartcampus.models.Room;
import uk.ac.westminster.smartcampus.storage.DataStore;

import java.util.Collection;

/**
 * RoomResource handles all operations related to Room entities.
 * 
 * Base path: /api/v1/rooms
 * 
 * Demonstrates:
 * - RESTful design
 * - Proper HTTP methods
 * - Business logic validation
 */
@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    /**
     * GET /api/v1/rooms
     * Retrieve all rooms
     */
    @GET
    public Collection<Room> getAllRooms() {
        return DataStore.rooms.values();
    }

    /**
     * POST /api/v1/rooms
     * Create a new room
     */
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

    /**
     * GET /api/v1/rooms/{id}
     * Retrieve a specific room
     */
    @GET
    @Path("/{id}")
    public Response getRoomById(@PathParam("id") String id) {

        Room room = DataStore.rooms.get(id);

        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }

        return Response.ok(room).build();
    }

    /**
     * DELETE /api/v1/rooms/{id}
     * 
     * Business Rule:
     * A room cannot be deleted if it has sensors assigned.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") String id) {

        Room room = DataStore.rooms.get(id);

        // Check if room exists
        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }

        // BUSINESS RULE: Cannot delete if sensors exist
        if (room.getSensorIds() != null && !room.getSensorIds().isEmpty()) {
            return Response.status(Response.Status.CONFLICT) // 409
                    .entity("Cannot delete room: Sensors are still assigned to this room")
                    .build();
        }

        // Remove room from datastore
        DataStore.rooms.remove(id);

        return Response.ok("Room deleted successfully").build();
    }
}