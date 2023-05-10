package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date data;
    private List<ItemdoPedido> produtos;
    private Cliente cliente;
    private double valorTotal;

    public double getValorTotal() {
        return valorTotal;
    }
    public Date getData() {
        return data;
    }
    public List<ItemdoPedido> getProdutos() {
        return produtos;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        produtos = new ArrayList<ItemdoPedido>();
    }

    public void adicionarProdutoNaLista(Produto produto, int quantidade) {
        ItemdoPedido item = new ItemdoPedido(produto, quantidade);
        this.produtos.add(item);
        valorTotal += produto.compraProduto(item.getQuantidade());
    }

    public void removerProdutoDaLista(ItemdoPedido item) {
        valorTotal -= item.getProduto()
            .devolverProduto(item.getQuantidade());
        this.produtos.remove(item);
    }

    public void finalizaPedido() {
        data = new Date();
        System.out.println("Cliente: " + cliente.getNome());
        imprimeProdutos();
        System.out.println("Total do pedido: " + valorTotal);
        cliente.adicionaPedidoAoHistorico(this);
    }

    public void imprimeProdutos() {
        for (ItemdoPedido item : produtos) {
            System.out.println("Produto: " + item.getNome() + ", Quantidade: " + item.getQuantidade() + ", Total Item: " + item.getValorTotal());
        }
    }
}
