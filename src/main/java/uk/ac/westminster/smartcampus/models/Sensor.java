package uk.ac.westminster.smartcampus.models;

/**
 * Sensor represents a device installed in a room.
 * 
 * Each sensor:
 * - Belongs to a room (roomId)
 * - Has a type (Temperature, CO2, etc.)
 * - Has a status (ACTIVE, MAINTENANCE, OFFLINE)
 * - Stores the latest reading value
 */
public class Sensor {

    private String id;          // Unique sensor ID (e.g., TEMP-001)
    private String type;        // Sensor type (Temperature, CO2, etc.)
    private String status;      // ACTIVE, MAINTENANCE, OFFLINE
    private double currentValue; // Latest recorded value
    private String roomId;      // The room this sensor belongs to

    // Default constructor (required for JSON deserialization)
    public Sensor() {
    }

    /**
     * Get sensor ID
     */
    public String getId() {
        return id;
    }

    /**
     * Set sensor ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get sensor type
     */
    public String getType() {
        return type;
    }

    /**
     * Set sensor type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get sensor status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set sensor status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get latest sensor value
     */
    public double getCurrentValue() {
        return currentValue;
    }

    /**
     * Set latest sensor value
     */
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Get associated room ID
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * Set associated room ID
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}