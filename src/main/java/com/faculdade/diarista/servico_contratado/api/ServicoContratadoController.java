package com.faculdade.diarista.servico_contratado.api;

import com.faculdade.diarista.comum.security.UserSS;
import com.faculdade.diarista.comum.service.UserService;
import com.faculdade.diarista.servico.dominio.ServicoRepository;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratado;
import com.faculdade.diarista.servico_contratado.dominio.ServicoContratadoRepository;
import com.faculdade.diarista.usuario.dominio.Usuario;
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
@RequestMapping("/api/v1/servico-contratado")
@RequiredArgsConstructor
public class ServicoContratadoController {

    private final ServicoContratadoRepository servicoContratadoRepository;
    private final ServicoRepository servicoRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<ServicoContratadoDTO> cadastrarServicoContratado(@RequestBody @Valid ServicoContratadoForm form, UriComponentsBuilder uriBuilder) {
        ServicoContratado servicoContratado = form.converter(servicoRepository, usuarioRepository);
        servicoContratadoRepository.save(servicoContratado);
        URI uri = uriBuilder.path("/api/v1/servico/{id}").buildAndExpand(servicoContratado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ServicoContratadoDTO(servicoContratado));
    }

    @GetMapping
    public ResponseEntity<Page<ServicoContratadoDTO>> buscarPorPagina(Pageable paginacao, @RequestParam(required = false) Integer idPrestador) {

        if (idPrestador == null) {
            UserSS usuario = UserService.authenticated();
            Usuario usuarioContratante = usuarioRepository.findById(usuario.getId())
                    .orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));


            Page<ServicoContratado> servicoContratados = servicoContratadoRepository.findByUsuarioContratante(paginacao, usuarioContratante);
            return ResponseEntity.ok(ServicoContratadoDTO.converter(servicoContratados));
        } else {
            Usuario usuarioPrestador = usuarioRepository.findById(idPrestador)
                    .orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
            Page<ServicoContratado> servicoPrestado = servicoContratadoRepository.findByServicoUsuario(paginacao, usuarioPrestador);
            return ResponseEntity.ok(ServicoContratadoDTO.converter(servicoPrestado));
        }
    }

}
