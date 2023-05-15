package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import Models.Cliente;
import controllers.ClienteController;

public class ClienteTests {
    @Test
    public void testaClienteController() {
        int quantidadeInicialDeClientes = ClienteController.quantidadeDeClientes();
        Cliente cliente = new Cliente("marcos", "Rua 1", "12345");

        ClienteController.adicionaCliente(cliente);
        int quantidadeAposAdicionaUmCliente = ClienteController.quantidadeDeClientes();

        assertEquals(quantidadeAposAdicionaUmCliente, quantidadeInicialDeClientes + 1);
        assertEquals(cliente, ClienteController.buscaClientePorPosicao(quantidadeInicialDeClientes));

        ClienteController.removeCliente(cliente);
        int quantidadeAposRemoverCLiente = ClienteController.quantidadeDeClientes();

        assertEquals(quantidadeInicialDeClientes, quantidadeAposRemoverCLiente);
    }

    @Test
    public void testaBuscaClientePorNome() {
        Cliente cliente = ClienteController.buscaClientePorNome("Mateus");
        assertNotNull(cliente);
    }

    @Test
    public void testaNaoEncontrarClienteNaBusca() {
        Cliente cliente = ClienteController.buscaClientePorNome("Lucas");
        assertNull(cliente);
    }

    @Test
    public void testaTotalDeComprasPorCliente() {
        double valor = ClienteController.totalDeComprasPorCliente(0);
        assertNotNull(valor);
    }
}
