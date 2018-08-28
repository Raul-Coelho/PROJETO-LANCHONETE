package model;

public class Produto {

    private int codProduto;
    private String nome;
    private float precoUnitario;
    private String descricao;

    public Produto(int codProduto, String nome, float precoUnitario, String descricao) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.descricao = descricao;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codProduto=" + codProduto +
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

