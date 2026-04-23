package uk.ac.westminster.smartcampus.models;

/*
 * Represents a single recorded measurement from a sensor.
 * Each reading is time-based and stored per sensor.
 */
public class SensorReading {

    private String id;       // Unique reading ID (UUID recommended)
    private long timestamp;  // Time of reading (epoch milliseconds)
    private double value;    // Measured value

    public SensorReading() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}