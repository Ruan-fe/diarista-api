package com.faculdade.diarista.comum.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity hadleException(RecursoDuplicadoException re){

        DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.toString(), re.toString());

        return new ResponseEntity(erro,HttpStatus.BAD_REQUEST);
    }

}
