package utils;

import Models.Funcionario;
import Models.Pedido;
import controllers.PedidoController;
import telas.TelaProduto;
import utils.interfaces.IOpcoesMenuFuncionario;

public class OpcoesMenuFuncionario implements IOpcoesMenuFuncionario {
    @Override
    public void exibirEstoque() {
        TelaProduto.exibirListaDeProdutos();
    }
    
    @Override
    public void criarProduto() {
       TelaProduto.adicionarProduto();
    }

    @Override
    public void adicionarQuantidadeDeProduto() {
        TelaProduto.adicionaQuantidadeAProduto();
    }

    @Override
    public void removerProduto() {
        TelaProduto.removerProdutoDoEstoque();
    }

    @Override
    public void listarClientes(Funcionario funcionario) {
        UtilsMenuFuncionario.exibeTodosOsClientes();
        if (funcionario.getCargo().equals("Chefe")) {
            int opcao = Utilitarios.recebeOpcaoNumerica(
                "Deseja exluir algum cliente?\n0- Sim\n1- Não", 2
            );
            if (opcao == 0) {
                UtilsMenuFuncionario.removeCliente();
            }
        }
    }

    @Override
    public void listarPedidos() {
        System.out.println(String.format(
            "| %-4s %-20s %-11s |",
            "Cod",
            "Cliente",
            "Valor total"
        ));
        for (int i = 0; i < PedidoController.quantidadeDePedidos(); i++) {
            Pedido pedido = PedidoController.buscaPedidoPorPosicao(i);
            System.out.println(String.format(
                "| %-4d %-20s R$%-7.2f |",
                i,
                pedido.getCliente().getNome(),
                pedido.getValorTotal()
            ));
        }
    }

    @Override
    public void gerarRelatorioDeVendas() {
        System.out.println("Quantidade de pedidos: " + PedidoController.quantidadeDePedidos() + ", Total em vendas: " + PedidoController.buscaTotalDeVendas());
    }
}
