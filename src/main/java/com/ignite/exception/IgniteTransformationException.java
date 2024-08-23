package com.ignite.exception;

public class IgniteTransformationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final int code;

    /**
     * Status, error code and exception
     *
     * @param exc          exception
     * @param statusFailed statusFailed
     */
    public IgniteTransformationException(String statusFailed, int code, Exception exc) {
        super(exc);
        this.code = code;
    }

    /**
     * Message, cause and code
     *
     * @param message message
     * @param cause   cause
     */
    public IgniteTransformationException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    /**
     * Message and code
     *
     * @param message message
     */
    public IgniteTransformationException(String message, int code) {
        super(message);
        this.code = code;
    }

    /**
     * Cause and code
     *
     * @param cause cause
     */
    public IgniteTransformationException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    /**
     * It returns error code
     *
     * @return error code
     */
    public int getCode() {
        return this.code;
    }
}
