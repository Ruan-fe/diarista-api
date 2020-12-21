package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
    public ResponseEntity<ServicoDTO> cadastrarServico(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder){
        Servico servico = form.converter(usuarioRepository);
        servicoRepository.save(servico);
        URI uri = uriBuilder.path("/api/v1/servico/{id}").buildAndExpand(servico.getId()).toUri();
        return ResponseEntity.created(uri).body(new ServicoDTO(servico));
    }

    @GetMapping
    public ResponseEntity<Page<ServicoDTO>> buscarPorPagina(Pageable paginacao) {
        Page<Servico> servicos = servicoRepository.findAll(paginacao);

        return ResponseEntity.ok(ServicoDTO
                .converter(servicos));
    }

    @PutMapping("/{idServico}")
    public ResponseEntity<ServicoDTO> atualizarAtivo(@PathVariable Integer idServico,
                                                     @RequestBody @Valid EdicaoServicoForm form){
        Servico servico = servicoRepository.findById(idServico)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Serviço não encontrado"));
        servico.setAtivo(form.getAtivo());
        return ResponseEntity.ok(new ServicoDTO(servicoRepository.save(servico)));
    }


}
