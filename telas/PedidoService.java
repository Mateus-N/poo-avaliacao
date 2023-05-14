package telas;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Produto;
import controllers.ProdutoController;
import utils.PedidoBuilder;
import utils.Utilitarios;

public class PedidoService {
    public static void fazerPedido(Cliente cliente) {
        System.out.println("Criando pedido de Nº" + cliente.getHistoricoDePedidos().size() + " para o cliente " + cliente.getNome());
        PedidoBuilder builder = new PedidoBuilder();
        builder.iniciarPedido(cliente);
        int opcao;
        do {
            adicionarItemAoPedido(builder);
            opcao = Utilitarios.recebeOpcaoNumerica("Adicionar novo item?\n0- Sim\n1- Não", 2);
        } while (opcao != 1);
        builder.finalizaPedido();
        System.out.println("Pedido finalizado e adiciona a sua lista!");
    }

    private static void adicionarItemAoPedido(PedidoBuilder builder) {
        Produto produto = escolherProduto();
        if (produto.getQuantidade() > 0) {
            int quantidade = Utilitarios.recebeOpcaoNumerica(
                "Qual a quantidade que deseja adicionar ao pedido?",
                produto.getQuantidade()
            );
            builder.adicionaItemAoPedido(
                new ItemdoPedido(produto, quantidade)
            );
        } else {
            System.out.println("Escolha um produto com quantidade");
        }
    }

    private static Produto escolherProduto() {
        ProdutoService.exibirListaDeProdutos();
        int quantidadeDeProdutos = ProdutoController.buscarTodosOsProdutos().size();
        int posicaoDoProdutoEscolhido = Utilitarios.recebeOpcaoNumerica(
            "Escolha o produto para adicionar ao pedido\n(Digite o cod para escolher o produto)",
            quantidadeDeProdutos
        );
        return ProdutoController.buscaProdutoPorPosicao(posicaoDoProdutoEscolhido);
    }
}
