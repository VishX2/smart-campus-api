package uk.ac.westminster.smartcampus.storage;

import uk.ac.westminster.smartcampus.models.Room;
import uk.ac.westminster.smartcampus.models.Sensor;

import java.util.HashMap;
import java.util.Map;

/**
 * DataStore acts as an in-memory database.
 * 
 * IMPORTANT:
 * - No real database is used (as required by coursework)
 * - Data is stored using HashMaps
 * - Data will RESET when server restarts
 */
public class DataStore {

    /**
     * Stores all rooms
     * Key: Room ID (e.g., LIB-301)
     */
    public static Map<String, Room> rooms = new HashMap<>();

    /**
     * Stores all sensors
     * Key: Sensor ID (e.g., TEMP-001)
     */
    public static Map<String, Sensor> sensors = new HashMap<>();

}