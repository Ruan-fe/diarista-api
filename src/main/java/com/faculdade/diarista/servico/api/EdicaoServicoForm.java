package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.servico.dominio.Servico;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EdicaoServicoForm {

    @NotNull
    private Boolean ativo;

    EdicaoServicoForm(Servico servico){
        ativo = servico.getAtivo();
    }


}
