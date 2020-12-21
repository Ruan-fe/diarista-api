package com.faculdade.diarista.servico.api;

import com.faculdade.diarista.comum.enums.CategoriaServico;
import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class ServicoForm {

    @NotNull(message = "{campo.titulo.obrigatorio}")
    @NotEmpty(message = "{campo.titulo.obrigatorio}")
    private String titulo;

    @NotNull(message = "{campo.descricao.obrigatorio}")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull
    private Integer usuario;

    @NotNull
    private CategoriaServico categoriaServico;

    @NotNull(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;

    @NotNull(message = "{campo.disponibilidade.obrigatorio}")
    @NotEmpty(message = "{campo.disponibilidade.obrigatorio}")
    private String disponibilidade;

    public Servico converter(UsuarioRepository usuarioRepository){
        Usuario usuario = usuarioRepository
                .findById(this.usuario)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado"));

        return new Servico(null,titulo,descricao,usuario,categoriaServico,ativo,disponibilidade,null);
    }

}
