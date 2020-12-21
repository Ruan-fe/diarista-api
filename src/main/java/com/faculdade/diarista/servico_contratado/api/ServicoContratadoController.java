package com.faculdade.diarista.servico_contratado.api;

import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratado;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratadoRepository;
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
@RequestMapping("/api/v1/servico-contratado")
@RequiredArgsConstructor
public class ServicoContratadoController {

    private final ServicoContratadoRepository servicoContratadoRepository;
    private final ServicoRepository servicoRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<ServicoContratadoDTO> cadastrarServicoContratado(@RequestBody @Valid ServicoContratadoForm form, UriComponentsBuilder uriBuilder){
        ServicoContratado servicoContratado = form.converter(servicoRepository, usuarioRepository);
        servicoContratadoRepository.save(servicoContratado);
        URI uri = uriBuilder.path("/api/v1/servico/{id}").buildAndExpand(servicoContratado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ServicoContratadoDTO(servicoContratado));
    }




}
