package uk.ac.westminster.smartcampus.exceptions;

/*
 * Thrown when a resource references another resource that does not exist.
 * Example: Sensor referencing a non-existent roomId.
 */
public class LinkedResourceNotFoundException extends RuntimeException {

    public LinkedResourceNotFoundException(String message) {
        super(message);
    }
}