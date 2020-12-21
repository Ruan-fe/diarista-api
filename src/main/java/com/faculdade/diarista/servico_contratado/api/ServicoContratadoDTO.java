package com.faculdade.diarista.servico_contratado.api;

import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratado;
import com.faculdade.diarista.usuario.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDate;


@Getter
@Setter
public class ServicoContratadoDTO {

    private Integer id;
    private Servico servico;
    private Usuario usuarioContratante;
    private LocalDate dataContratado;


    public ServicoContratadoDTO(ServicoContratado servicoContratado){

        id = servicoContratado.getId();
        servico = servicoContratado.getServico();
        usuarioContratante = servicoContratado.getUsuarioContratante();
        dataContratado = servicoContratado.getDataContratado();
    }

    public static Page<ServicoContratadoDTO> converter(Page<ServicoContratado> servicosContratado) {
        return servicosContratado.map(ServicoContratadoDTO::new);
    }



}
