package edu.utexas.tacc.tapis.notifications.lib.exceptions;

public class DuplicateEntityException extends Exception {

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable err) {
        super(message, err);
    }
}
