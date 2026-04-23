package uk.ac.westminster.smartcampus.exceptions;

/*
 * Thrown when a sensor cannot accept readings due to its current state.
 */
public class SensorUnavailableException extends RuntimeException {

    public SensorUnavailableException(String message) {
        super(message);
    }
}