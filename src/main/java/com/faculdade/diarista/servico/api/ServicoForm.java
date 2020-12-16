package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.comum.enums.CategoriaServico;
import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class ServicoForm {

    @NotNull
    private String titulo;
    @NotNull
    private String descricao;
    @NotNull
    private Integer usuario;
    @NotNull
    private CategoriaServico categoriaServico;
    @NotNull
    private Boolean ativo;
    @NotNull
    private String disponibilidade;

    public Servico converter(UsuarioRepository usuarioRepository){
        Usuario usuario = usuarioRepository
                .findById(this.usuario)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado"));

        return new Servico(null,titulo,descricao,usuario,categoriaServico,ativo,disponibilidade,null);
    }

}
