package br.com.yago.blogspring.model.enums;

public enum FuncaoEnum {

    ADMINISTRADOR(1, "Administrador"),
    MODERADOR(2, "Moderador"),
    REVISOR(3, "Revisor"),
    AUTOR(3, "Autor");

    private int id;
    private String descricao;

    FuncaoEnum(final int id, final String descricao) { this.id = id; this.descricao = descricao; }

    /**
     * Retorna id.
     *
     * @return propriedade id {@link int}
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna descricao.
     * @return propriedade descricao {@link String}
     */
    public String getDescricao() { return descricao; }
}
