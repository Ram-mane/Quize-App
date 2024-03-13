package com.quizeapp.QuizeApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  // You can customize the HTTP status code as needed
public class QuizException extends RuntimeException {

    public QuizException(String message) {
        super(message);
    }

    // You can add more constructors or methods if needed

}

