package com.faculdade.diarista.comum.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {
    private String code;
    private String message;

}
