package Models;

public class ItemdoPedido {
    private Produto produto;
    private int quantidade;
    private String nome;
    private double valorTotal;

    public ItemdoPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        nome = produto.getNome();
        valorTotal = produto.getPrecoUnitario() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public String getNome() {
        return nome;
    }
    public double getValorTotal() {
        return valorTotal;
    }
}
