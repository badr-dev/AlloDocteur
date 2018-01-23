/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.exception;

/**
 *
 * @author badredine
 */
public class CustomException extends RuntimeException {
 
    public static int ERROR_SQL_CONNECTION = 999;
    
    private int code;

    public CustomException(int code) {
        super();
        this.code = code;
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public CustomException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}

