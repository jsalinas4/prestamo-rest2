package com.TechConnecGrupo3.TechConnecapi.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
