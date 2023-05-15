package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import Models.Funcionario;
import controllers.FuncionarioController;

public class FuncionarioTests {
    @Test
    public void testaBuscaFuncionarioPorNome() {
        Funcionario funcionario = FuncionarioController.buscaFuncionario("Remy");
        assertNotNull(funcionario);
    }

    @Test
    public void testaNaoEncotrarFuncionarioNaBusca() {
        Funcionario funcionario = FuncionarioController.buscaFuncionario("Mateus");
        assertNull(funcionario);
    }
}
