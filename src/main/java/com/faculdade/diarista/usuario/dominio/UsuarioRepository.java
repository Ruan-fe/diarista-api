package com.faculdade.diarista.usuario.dominio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByEmail(String email);

}
