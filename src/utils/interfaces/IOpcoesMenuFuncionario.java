package utils.interfaces;

import Models.Funcionario;

public interface IOpcoesMenuFuncionario {
    void exibirEstoque();

    void criarProduto();

    void adicionarQuantidadeDeProduto();

    void removerProduto();

    void listarClientes(Funcionario funcionario);

    void listarPedidos();

    void gerarRelatorioDeVendas();
}
