package uk.ac.westminster.smartcampus.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import uk.ac.westminster.smartcampus.models.Room;
import uk.ac.westminster.smartcampus.storage.DataStore;

import java.util.Collection;

/**
 * RoomResource handles all HTTP operations related to Room entities.
 * 
 * Base path: /api/v1/rooms
 * 
 * This class demonstrates RESTful principles:
 * - Resource-based URL design
 * - Proper HTTP methods (GET, POST)
 * - Appropriate status codes
 */
@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)   // All responses will be JSON
@Consumes(MediaType.APPLICATION_JSON)   // Accept JSON input
public class RoomResource {

    /**
     * GET /api/v1/rooms
     * 
     * Retrieves all rooms in the system.
     * 
     * @return Collection of Room objects stored in memory
     */
    @GET
    public Collection<Room> getAllRooms() {
        // Return all values from the in-memory datastore
        return DataStore.rooms.values();
    }

    /**
     * POST /api/v1/rooms
     * 
     * Creates a new room.
     * The client must provide a valid Room object in JSON format.
     * 
     * Example JSON:
     * {
     *   "id": "LIB-301",
     *   "name": "Library Study Room",
     *   "capacity": 50
     * }
     * 
     * @param room The Room object received from the client
     * @return HTTP 201 (Created) with the created room,
     *         or HTTP 400 if input is invalid
     */
    @POST
    public Response createRoom(Room room) {

        // Validate that the room ID is provided
        if (room.getId() == null || room.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Room ID is required")
                    .build();
        }

        // Store the room in memory using its ID as the key
        DataStore.rooms.put(room.getId(), room);

        // Return HTTP 201 Created with the created object
        return Response.status(Response.Status.CREATED)
                .entity(room)
                .build();
    }

    /**
     * GET /api/v1/rooms/{id}
     * 
     * Retrieves a specific room by its unique ID.
     * 
     * Example:
     * GET /api/v1/rooms/LIB-301
     * 
     * @param id The room ID from the URL path
     * @return HTTP 200 with room data if found,
     *         or HTTP 404 if the room does not exist
     */
    @GET
    @Path("/{id}")
    public Response getRoomById(@PathParam("id") String id) {

        // Retrieve room from datastore
        Room room = DataStore.rooms.get(id);

        // If room does not exist, return 404 Not Found
        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }

        // Return 200 OK with the room data
        return Response.ok(room).build();
    }
}