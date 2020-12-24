package com.faculdade.diarista.servico_contratado.api;

import com.faculdade.diarista.comum.exceptions.UsuarioNaoPodeContratarOMesmoServicoException;
import com.faculdade.diarista.comum.security.UserSS;
import com.faculdade.diarista.comum.service.UserService;
import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratado;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Getter
public class ServicoContratadoForm {

    private Integer servico;
    private Integer usuarioContratante;

    public ServicoContratado converter(ServicoRepository servicoRepository, UsuarioRepository usuarioRepository){

        Servico servico = servicoRepository
                .findById(this.servico)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Serviço não encontrado"));

        UserSS usuario = UserService.authenticated();

        if(usuario.getId() == servico.getUsuario().getId()){
            throw new UsuarioNaoPodeContratarOMesmoServicoException(usuario.getUsername());
        }

        Usuario usuarioContratante = usuarioRepository.findById(usuario.getId())
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado"));


        return new ServicoContratado(null, usuarioContratante, servico, null );
    }
}
