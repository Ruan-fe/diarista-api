package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.servico.dominio.Servico;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EdicaoServicoForm {

    @NotNull
    private Boolean ativo;

    EdicaoServicoForm(Servico servico){
        ativo = servico.getAtivo();
    }


}
