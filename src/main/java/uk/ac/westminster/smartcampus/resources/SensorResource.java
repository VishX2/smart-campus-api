package uk.ac.westminster.smartcampus.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import uk.ac.westminster.smartcampus.models.Sensor;
import uk.ac.westminster.smartcampus.models.Room;
import uk.ac.westminster.smartcampus.storage.DataStore;

import java.util.Collection;
import java.util.stream.Collectors;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @GET
    public Collection<Sensor> getAllSensors(@QueryParam("type") String type) {

        // If no filter is provided, return all sensors
        if (type == null || type.isEmpty()) {
            return DataStore.sensors.values();
        }

        // Filter sensors by type (e.g., Temperature, CO2)
        return DataStore.sensors.values()
                .stream()
                .filter(sensor -> sensor.getType() != null &&
                                  sensor.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @POST
    public Response createSensor(Sensor sensor) {

        // Basic validation for required ID
        if (sensor.getId() == null || sensor.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Sensor ID is required")
                    .build();
        }

        // Ensure the referenced room exists before creating sensor
        Room room = DataStore.rooms.get(sensor.getRoomId());

        if (room == null) {
            return Response.status(422)
                    .entity("Room does not exist for the given roomId")
                    .build();
        }

        // Store sensor and link it to the room
        DataStore.sensors.put(sensor.getId(), sensor);
        room.getSensorIds().add(sensor.getId());

        return Response.status(Response.Status.CREATED)
                .entity(sensor)
                .build();
    }
}