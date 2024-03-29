package com.NSTGroupe.institut.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity handlerResourceNotFound(ResourceNotFound exception){

        Response response = new Response();
        response.setDate(new Date());
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity handlerConnectException(ConnectException exception){

        Response response = new Response();
        response.setDate(new Date());
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        response.setMessage("Service non disponible temporairement");
        // générer une notification
        // envoyer email à l'adminitsrateur
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}
