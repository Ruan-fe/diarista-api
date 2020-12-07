package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.comum.enums.CategoriaServico;
import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.usuario.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private Usuario usuario;
    private CategoriaServico categoriaServico;
    private Boolean status;
    private String disponibilidade;


    public ServicoDTO(Servico servico){

        id = servico.getId();
        titulo = servico.getTitulo();
        descricao = servico.getDescricao();
        usuario = servico.getUsuario();
        categoriaServico = servico.getCategoriaServico();
        status = servico.getStatus();
        disponibilidade = servico.getDisponibilidade();

    }
}
