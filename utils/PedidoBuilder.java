package utils;

import java.util.Date;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Pedido;

public class PedidoBuilder {
    private Pedido pedido;

    public void iniciarPedido(Cliente cliente) {
        pedido = new Pedido(cliente);
    }

    public void adicionaItemAoPedido(ItemdoPedido item) {
        pedido.adicionaItem(item);
    }

    public void finalizaPedido(Cliente cliente) {
        pedido.setData(new Date());
        cliente.addPedidoAoHistorico(pedido);
    }
}
