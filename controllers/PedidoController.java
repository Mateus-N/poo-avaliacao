package controllers;

import java.util.List;

import Models.Pedido;
import data.Database;

public class PedidoController {
    private static List<Pedido> pedidos = Database.getPedidos();

    public static void adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public static void cancelaPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public static double buscaTotalDeVendas() {
        double totalDeVendas = 0;
        for (Pedido pedido : pedidos) {
            totalDeVendas += pedido.getValorTotal();
        }
        return totalDeVendas;
    }

    public static Pedido buscaPedidoPorPosicao(int posicao) {
        return pedidos.get(posicao);
    }

    public static int quantidadeDePedidos() {
        return pedidos.size();
    }
}
