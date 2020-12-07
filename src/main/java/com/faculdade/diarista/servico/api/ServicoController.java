package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/servico")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoRepository servicoRepository;
    private final UsuarioRepository usuarioRepository;


    @PostMapping
    ResponseEntity<ServicoDTO> cadastrarUsuario(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder){
        Servico servico = form.converter(usuarioRepository);
        servicoRepository.save(servico);
        URI uri = uriBuilder.path("/api/v1/servico/{id}").buildAndExpand(servico.getId()).toUri();
        return ResponseEntity.created(uri).body(new ServicoDTO(servico));
    }



}
