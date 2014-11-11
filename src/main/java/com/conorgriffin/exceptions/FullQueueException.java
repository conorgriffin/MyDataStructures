package com.conorgriffin.exceptions;

public class FullQueueException extends Exception {
    /**
     * Generic exception to indicate an invalid operation was attempted on a full queue
     */
    private static final long serialVersionUID = 1L;

    public FullQueueException (String err) {
        super(err);
    }
}
