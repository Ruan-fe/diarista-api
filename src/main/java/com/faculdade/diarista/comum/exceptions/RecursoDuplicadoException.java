package com.faculdade.diarista.comum.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
public class RecursoDuplicadoException extends RuntimeException {

    private static final long serialVersionUID = 4006381572748946247L;

    @Getter
    public final String nomeEntidade;

    @Getter
    public final String idEntidade;

   public String toString(){
        return "Já existe um " + nomeEntidade + " com esse valor " + idEntidade;
    }

}