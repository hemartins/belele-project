/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.exception;

import org.apache.logging.log4j.Logger;

/**
 *
 * @author P056913
 */
public class BeleleException extends Exception {

    private static final long serialVersionUID = 6652211268631981701L;

    protected boolean isLogged = false;

    /* ******************************************************************************
	 * 
	 * 				CONSTRUCTORS
	 * 
	 *******************************************************************************/
    /**
     * Base Exception Constructor
     */
    public BeleleException() {
	super();
    }

    /**
     * @param message
     */
    public BeleleException(String message) {
	super(message);

    }

    /**
     * @param cause
     */
    public BeleleException(Throwable cause) {
	super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BeleleException(String message, Throwable cause) {
	super(message, cause);
    }


    /* ******************************************************************************
	 * 
	 * 				GETTERS / SETTERS
	 * 
	 *******************************************************************************/
    public boolean getIsLogged() {
	return isLogged;
    }


    /* ******************************************************************************
	 * 
	 * 				LOGGER
	 * 
	 *******************************************************************************/
    public void printLogError(Logger log) {
	if (isLogged == false && log != null) {
	    log.error(this.getMessage(), this);
	    isLogged = true;
	}
    }

}
