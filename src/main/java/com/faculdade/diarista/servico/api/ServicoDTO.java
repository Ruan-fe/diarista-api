package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.servico.dominio.Servico;
import lombok.*;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ServicoDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private Integer usuario;
    private String categoriaServico;
    private Boolean ativo;
    private String disponibilidade;
    private LocalDate dataAbertura;


    public ServicoDTO(Servico servico){

        id = servico.getId();
        titulo = servico.getTitulo();
        descricao = servico.getDescricao();
        usuario = servico.getUsuario().getId();
        categoriaServico = servico.getCategoriaServico().getDescricao();
        ativo = servico.getAtivo();
        disponibilidade = servico.getDisponibilidade();
        dataAbertura = servico.getDataAbertura();


    }

    public static Page<ServicoDTO> converter(Page<Servico> servicos) {
        return servicos.map(ServicoDTO::new);
    }

    public static List<ServicoDTO> converterToList(List<Servico> listServicos) {
        return listServicos.stream().map(ServicoDTO::new).collect(Collectors.toList());
    }
}
