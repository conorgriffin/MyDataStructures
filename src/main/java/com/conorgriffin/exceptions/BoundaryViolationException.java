package com.conorgriffin.exceptions;

/**
 * This exception is thrown when a value is out of range.  For example, a BoundaryViolationException
 * would be thrown if an attempt was made to insert an item beyond the end or before the beginning
 * of an array.
 * 
 * @author conorgriffin
 *
 */
public class BoundaryViolationException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BoundaryViolationException() {
        super();
    }

    public BoundaryViolationException(String message) {
        super(message);
    }

    public BoundaryViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoundaryViolationException(Throwable cause) {
        super(cause);
    }

}