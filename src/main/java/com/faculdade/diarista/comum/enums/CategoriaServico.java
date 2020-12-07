package com.faculdade.diarista.comum.enums;

public enum CategoriaServico {

    ASSISTENCIA_TECNICA("Assistência Técnica"),
    DOMESTICO("Serviços Domésticos"),
    SAUDE("Saúde"),
    REFORMA("Reformas"),
    TECNOLOGIA("Tecnologia"),
    DESIGN("Design"),
    AULA("Aulas"),
    EVENTO("Eventos");

    private String descricao;

    CategoriaServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
