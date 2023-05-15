package telas;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Produto;
import controllers.IngredientesController;
import controllers.ProdutoController;
import utils.PedidoBuilder;
import utils.Utilitarios;

public class TelaPedido {
    public static void fazerPedido(Cliente cliente, String cardapioOuPersonalizado) {
        System.out.println("Criando pedido de Nº" + cliente.getHistoricoDePedidos().size() + " para o cliente " + cliente.getNome());
        PedidoBuilder builder = new PedidoBuilder();
        builder.iniciarPedido(cliente);
        int opcao;
        do {
            adicionarItemAoPedido(builder, cardapioOuPersonalizado);
            opcao = Utilitarios.recebeOpcaoNumerica("Adicionar novo item?\n0- Sim\n1- Não", 2);
        } while (opcao != 1);
        verificaSeDesejaEntrega(builder);
        double valorTotal = builder.finalizaPedido();
        System.out.println("Valor final do pedido: " + valorTotal);
        System.out.println("Pedido finalizado e adiciona a sua lista!");
    }

    private static void verificaSeDesejaEntrega(PedidoBuilder builder) {
        int opcao = Utilitarios.recebeOpcaoNumerica(
            "Deseja vir ao estabelecimento ou receber em sua residência?\n(A taxa de entrega é de 6 reais)\n0- Residência\n1- Retirada",
            2);
        if (opcao == 0) {
            System.out.println("Ok, o tempo estimado de entrega é de 30 minutos, a taxa será adicionada ao valor total do pedido");
            builder.adicionarTaxaDeEntrega();
        }
    }

    private static void adicionarItemAoPedido(PedidoBuilder builder, String cardapioOuPersonalizado) {
        Produto produto = null;
        if (cardapioOuPersonalizado == "cardapio") {
            produto = escolherProduto();
        } else if (cardapioOuPersonalizado == "personalizado") {
            produto = criarHamburguerPersonalizado();
        }
        if (produto.getQuantidade() > 0) {
            int quantidade = Utilitarios.recebeOpcaoNumerica(
                "Qual a quantidade que deseja adicionar ao pedido?",
                produto.getQuantidade()
            );
            builder.adicionaItemAoPedido(
                new ItemdoPedido(produto, quantidade),
                cardapioOuPersonalizado
            );
        } else {
            System.out.println("Escolha um produto com quantidade");
        }
    }

    private static Produto criarHamburguerPersonalizado() {
        TelaProduto.exibirListaDeIngredientes();
        int quantidadeDeIngredientes = IngredientesController.quantidadeTotalDeIngredientes();
        int posicaoDoIngredienteEscolhido = Utilitarios.recebeOpcaoNumerica(
            "Escolha o Ingrediente para adicionar ao pedido\n(Digite o cod para escolher o Ingrediente)",
            quantidadeDeIngredientes
        );
        return IngredientesController.buscaIngredientePorPosicao(posicaoDoIngredienteEscolhido);
    }

    private static Produto escolherProduto() {
        TelaProduto.exibirListaDeProdutos();
        int quantidadeDeProdutos = ProdutoController.quantidadeDeProdutos();
        int posicaoDoProdutoEscolhido = Utilitarios.recebeOpcaoNumerica(
            "Escolha o produto para adicionar ao pedido\n(Digite o cod para escolher o produto)",
            quantidadeDeProdutos
        );
        return ProdutoController.buscaProdutoPorPosicao(posicaoDoProdutoEscolhido);
    }
}
