package uk.ac.westminster.smartcampus.storage;

import uk.ac.westminster.smartcampus.models.Room;
import uk.ac.westminster.smartcampus.models.Sensor;
import uk.ac.westminster.smartcampus.models.SensorReading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {

    public static Map<String, Room> rooms = new HashMap<>();

    public static Map<String, Sensor> sensors = new HashMap<>();

    // Key = sensorId, Value = list of readings for that sensor
    public static Map<String, List<SensorReading>> readings = new HashMap<>();
}