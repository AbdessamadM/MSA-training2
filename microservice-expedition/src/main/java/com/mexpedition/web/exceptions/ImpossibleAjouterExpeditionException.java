package com.mexpedition.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ImpossibleAjouterExpeditionException extends RuntimeException{

    public ImpossibleAjouterExpeditionException(String s){
        super(s);
    }
}
