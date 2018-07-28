package model;

public class Produto {

    private int codProduto;
    private String nome;
    private float precoUnitario;

    public Produto(int codProduto, String nome, float precoUnitario) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
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

    @Override
    public String toString() {
        return "Produto{" +
                "codProduto=" + codProduto +
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}

