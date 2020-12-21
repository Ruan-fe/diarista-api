package com.faculdade.diarista.servico_contratado.api;

import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratado;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Getter
public class ServicoContratadoForm {

    private Integer servico;
    private Integer usuarioContratante;

    public ServicoContratado converter(ServicoRepository servicoRepository, UsuarioRepository usuarioRepository){

        Servico servico = servicoRepository
                .findById(this.servico)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Serviço não encontrado"));

        Usuario usuarioContratante = usuarioRepository.findById(this.usuarioContratante)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado"));


        return new ServicoContratado(null, usuarioContratante, servico, null );
    }
}
