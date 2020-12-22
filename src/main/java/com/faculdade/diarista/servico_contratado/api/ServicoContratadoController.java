package com.faculdade.diarista.servico_contratado.api;

import com.faculdade.diarista.servico.api.ServicoDTO;
import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratado;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratadoRepository;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<ServicoContratadoDTO>> buscarPorPagina(Pageable paginacao){
        Page<ServicoContratado> servicoContratados = servicoContratadoRepository.findAll(paginacao);

        return ResponseEntity.ok(ServicoContratadoDTO.converter(servicoContratados));
    }

}
