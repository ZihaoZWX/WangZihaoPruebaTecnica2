package com.mycompany.wangzihaopruebatecnica2.persistence.exceptions;

public class NonexistentEntityException extends Exception {
    /**
     * 
     * @param message
     * @param cause 
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     * 
     * @param message 
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
