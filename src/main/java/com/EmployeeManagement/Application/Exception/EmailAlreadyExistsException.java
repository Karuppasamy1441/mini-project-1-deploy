package com.EmployeeManagement.Application.Exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String msg){
        super(msg);
    }
}
