package com.faculdade.diarista.comum.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class UsuarioNaoPodeContratarOMesmoServicoException extends RuntimeException {

    private static final long serialVersionUID = 4006381572748946247L;

    @Getter
    public final String nomeEntidade;


   public String toString(){
        return nomeEntidade + " Você não pode contratar o seu mesmo serviço";
    }

}