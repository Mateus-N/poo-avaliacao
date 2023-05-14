package controllers;

import java.util.List;

import Models.Cliente;
import data.Database;

public class ClienteController {
    private static List<Cliente> clientes = Database.getClientes();

    public static void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static List<Cliente> buscaTodosClientes() {
        return clientes;
    }

    public static Cliente buscaClientePorNome(String nome) {
        return clientes.stream()
            .filter(c -> c.getNome().equals(nome))
            .findFirst()
            .orElse(null);
    }
}
