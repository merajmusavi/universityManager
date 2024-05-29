package com.example.universityManager.config;

import com.example.universityManager.dto.ErrorEntity;
import com.example.universityManager.exception.AlreadyExistsException;
import com.example.universityManager.exception.ConflictException;
import com.example.universityManager.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorEntity> handleConflictException(ConflictException conflictException) {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setStatus(conflictException.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorEntity> handleNotFoundException(NotFoundException notFoundException) {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setStatus(notFoundException.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorEntity> handleAlreadyExistsException(AlreadyExistsException alreadyExistsException) {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setStatus(alreadyExistsException.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.BAD_REQUEST);
    }
}
