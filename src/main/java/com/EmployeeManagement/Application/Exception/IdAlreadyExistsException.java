package com.EmployeeManagement.Application.Exception;

public class IdAlreadyExistsException extends RuntimeException{
    public IdAlreadyExistsException(String msg){
        super(msg);
    }
}
