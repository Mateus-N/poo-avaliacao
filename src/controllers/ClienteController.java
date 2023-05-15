package controllers;

import java.util.List;

import Models.Cliente;
import Models.Pedido;
import data.Database;

public class ClienteController {
    private static List<Cliente> clientes = Database.getClientes();

    public static void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static Cliente buscaClientePorPosicao(int posicao) {
        return clientes.get(posicao);
    }

    public static int quantidadeDeClientes() {
        return clientes.size();
    }

    public static Cliente buscaClientePorNome(String nome) {
        return clientes.stream()
            .filter(c -> c.getNome().equals(nome))
            .findFirst()
            .orElse(null);
    }

    public static double totalDeComprasPorCliente(int posicao) {
        Cliente cliente = buscaClientePorPosicao(posicao);
        double totalDeCompras = 0;
        for (Pedido pedido : cliente.getHistoricoDePedidos()) {
            totalDeCompras += pedido.getValorTotal();
        }
        return totalDeCompras;
    }
}
