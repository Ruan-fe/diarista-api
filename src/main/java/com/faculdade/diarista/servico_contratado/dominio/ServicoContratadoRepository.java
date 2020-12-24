package com.faculdade.diarista.servico_contratado.dominio;

import com.faculdade.diarista.usuario.dominio.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoContratadoRepository extends JpaRepository<ServicoContratado,Integer> {
    Page<ServicoContratado> findByUsuarioContratante(Pageable paginacao, Usuario usuarioContratante);
    Page<ServicoContratado> findByServicoUsuario(Pageable paginacao, Usuario usuarioPrestador);
}
