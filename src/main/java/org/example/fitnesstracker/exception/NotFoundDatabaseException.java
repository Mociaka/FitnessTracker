package org.example.fitnesstracker.exception;

public class NotFoundDatabaseException extends RuntimeException{
    public NotFoundDatabaseException(String message) {
        super(message);
    }
}
