package com.student.db.crud.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    ProblemDetail onException(RuntimeException runtimeException){
        var problemDetail = ProblemDetail.forStatus(404);
        problemDetail.setTitle("Student Not Found");
        problemDetail.setStatus(404);
        problemDetail.setDetail(runtimeException.getMessage());
        return problemDetail;
    }
}
