package utils;

import java.util.Date;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Pedido;
import controllers.PedidoController;
import controllers.ProdutoController;

public class PedidoBuilder {
    private Pedido pedido;

    public void iniciarPedido(Cliente cliente) {
        pedido = new Pedido(cliente);
    }

    public void adicionaItemAoPedido(ItemdoPedido item) {
        pedido.adicionaItem(item);
        ProdutoController.diminiuQuantidadeNoEstoqueAposVenda(
            item.getProduto(),
            item.getQuantidade()
        );
    }

    public void finalizaPedido() {
        pedido.setData(new Date());
        pedido.getCliente().addPedidoAoHistorico(pedido);
        PedidoController.adicionaPedido(pedido);
    }
}
