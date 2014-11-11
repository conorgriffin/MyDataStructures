package com.conorgriffin.exceptions;

public class EmptyQueueException extends Exception {
    /**
     * Generic exception to indicate an invalid operation was attempted on an empty queue
     */
    private static final long serialVersionUID = 1L;

    public EmptyQueueException (String err) {
        super(err);
    }
}
