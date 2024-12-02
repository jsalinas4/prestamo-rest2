package com.TechConnecGrupo3.TechConnecapi.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){
        super();
    }
    public BadRequestException(String message) {
        super(message);
    }
}
