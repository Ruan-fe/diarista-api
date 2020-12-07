package com.faculdade.diarista.servico.dominio;


import com.faculdade.diarista.comum.enums.CategoriaServico;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoriaServico categoriaServico;

    @NotNull
    private Boolean status;

    @NotNull
    private String disponibilidade;

}
