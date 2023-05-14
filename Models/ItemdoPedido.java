package Models;

public class ItemdoPedido {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ItemdoPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        valorTotal = produto.getPrecoUnitario() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getValorTotal() {
        return valorTotal;
    }
}
