package uk.ac.westminster.smartcampus.storage;

import uk.ac.westminster.smartcampus.models.Room;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    // In-memory storage for rooms
    public static Map<String, Room> rooms = new HashMap<>();

}