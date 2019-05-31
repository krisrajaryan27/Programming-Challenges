package com.nirvana.learning.moneytap.bitcoinsummary.exception;

public class ResourceNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    /** Creates a new instance of ResourceNotFoundException */
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String resource, int id) {
        super(resource + " with the given " + id + " is not present in the system");
    }
}
