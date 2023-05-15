package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Models.Pedido;
import controllers.PedidoController;

public class PedidoTests {
    @Test
    public void testaPedidoController() {
        Pedido pedido = new Pedido(null);
        int quantidadeInicialDePedidos = PedidoController.quantidadeDePedidos();

        PedidoController.adicionaPedido(pedido);
        int quantidadeAposAdicionarUmPedido = PedidoController.quantidadeDePedidos();

        assertEquals(quantidadeAposAdicionarUmPedido, quantidadeInicialDePedidos + 1);

        PedidoController.cancelaPedido(pedido);
        int quantidadeAposCancalarPedido = PedidoController.quantidadeDePedidos();

        assertEquals(quantidadeInicialDePedidos, quantidadeAposCancalarPedido);
    }
}
