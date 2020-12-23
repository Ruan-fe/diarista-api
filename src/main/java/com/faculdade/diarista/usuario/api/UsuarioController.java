package com.faculdade.diarista.usuario.api;

import com.faculdade.diarista.comum.exceptions.RecursoDuplicadoException;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){

        if (usuarioRepository.existsByEmail(form.getEmail()))
            throw new RecursoDuplicadoException("EMAIL", form.getEmail());

        if (usuarioRepository.existsByCpf(form.getCpf()))
            throw new RecursoDuplicadoException("CPF", form.getCpf());

        Usuario usuario = form.converter(bCryptPasswordEncoder);
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/api/v1/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }


    /*@GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarPorEmail(@RequestParam(required = true) String email){
        return ResponseEntity.ok(UsuarioDTO
                .converter(usuarioRepository.findByEmail(email)));
    }*/

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable Integer idUsuario, @RequestBody @Valid EdicaoUsuarioForm form){
        Usuario usuario = form.atualizar(idUsuario, usuarioRepository);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }



}
