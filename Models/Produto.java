package Models;

public class Produto {
    private String nome;
    private int quantidade;
    private double precoUnitario;

    public Produto(String nome, int quantidade, double precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int adicionaProdutosAoEstoque(int quantidade) {
        this.quantidade += quantidade;
        return this.quantidade;
    }

    public double compraProduto(int quantidade) {
        double valorTotal = quantidade * precoUnitario;
        this.quantidade -= quantidade;
        return valorTotal;
    }

    public double devolverProduto(int quantidade) {
        double valorTotal = quantidade * precoUnitario;
        this.quantidade += quantidade;
        return valorTotal;
    }
}
