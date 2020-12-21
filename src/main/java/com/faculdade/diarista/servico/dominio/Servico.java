package com.faculdade.diarista.servico.dominio;


import com.faculdade.diarista.comum.enums.CategoriaServico;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

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

    @ManyToOne
    @NotNull
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoriaServico categoriaServico;

    @NotNull
    private Boolean ativo;

    @NotNull
    private String disponibilidade;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;

    @PrePersist
    public void prePersist(){
        setDataAbertura(LocalDate.now());
    }

}
