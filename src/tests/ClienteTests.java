package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Models.Cliente;
import controllers.ClienteController;

public class ClienteTests {
    @Test
    public void testaCadastroDeCliente() {
        int quantidadeInicialDeClientes = ClienteController.quantidadeDeClientes();
        Cliente cliente = new Cliente("marcos", "Rua 1", "12345");

        ClienteController.adicionaCliente(cliente);
        int quantidadeFInalDeClientes = ClienteController.quantidadeDeClientes();

        assertEquals(quantidadeFInalDeClientes, quantidadeInicialDeClientes + 1);
        assertEquals(cliente, ClienteController.buscaClientePorPosicao(quantidadeInicialDeClientes));
    }
}
