package com.example.exceptionHandling.exceptionHandle;

import com.example.exceptionHandling.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<ErrorMessage> productNotException(ProductNotFound productNotFound, WebRequest webRequest){
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,productNotFound.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);


    }
}
