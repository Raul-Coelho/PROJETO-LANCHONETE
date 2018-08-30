package model;

/**
 *A classe Produto modela a entidade <b>Produto </b> do domínio da aplicação
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */
public class Produto {

    private int codProduto;
    private String nome;
    private float precoUnitario;
    private String descricao;

    /**
     * atributos da entidade <b>Produto </b>
     * @param codProduto indica o codigo do produto
     * @param nome indica o nome do produto
     * @param precoUnitario indica o preço do produto
     * @param descricao indica uma descrição sobre o produto
     */

    public Produto(int codProduto, String nome, float precoUnitario, String descricao) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.descricao = descricao;
    }
    /**
     * Retorna codigo do <b>Produto</b>
     * @return codigo
     */
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    /**
     * Retorna nome o <b>Produto</b>
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço do <b>Produto</b>
     * @return preço
     */
    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
     * Retorna a descrição <b>Produto</b>
     * @return descrição
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * metodo toString que é uma representação textual da classe
     *
     */
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

