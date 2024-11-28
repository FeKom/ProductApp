package com.product.app.exceptions;

public class SearchByNameException extends RuntimeException{
    
    public SearchByNameException() {super("produto não encontrado");}

    public SearchByNameException(String message) {super(message);}

}

