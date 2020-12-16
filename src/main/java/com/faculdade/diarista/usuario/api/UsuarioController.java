package com.faculdade.diarista.usuario.api;

import com.faculdade.diarista.servico.api.ServicoDTO;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
        Usuario usuario = form.converter();
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/api/v1/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarPorEmail(@RequestParam(required = true) String email){

        return ResponseEntity.ok(UsuarioDTO
                .converter(usuarioRepository.findByEmail(email)));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable Integer idUsuario, @RequestBody @Valid EdicaoUsuarioForm form){
        Usuario usuario = form.atualizar(idUsuario, usuarioRepository);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }



}
