package telas;

import java.util.Scanner;

import Models.Produto;
import controllers.ProdutoController;
import controllers.IngredientesController;
import utils.Utilitarios;

public class TelaProduto {
    private static Scanner in = new Scanner(System.in);

    public static void exibirListaDeProdutos() {
        System.out.println("---------------------------------------------");
        System.out.println(String.format("| %-3s %-20s %-10s %-5s |", 
            "Cod", "Nome", "Preço", "Quant"));
        for (int i = 0; i < ProdutoController.quantidadeDeProdutos(); i++) {
            if (ProdutoController.buscaProdutoPorPosicao(i).getQuantidade() > 0) {
                String linhaCardapio = String.format("| %-3d %-20s R$%-8.2f %-5d |", 
                    i,
                    ProdutoController.buscaProdutoPorPosicao(i).getNome(),
                    ProdutoController.buscaProdutoPorPosicao(i).getPrecoUnitario(),
                    ProdutoController.buscaProdutoPorPosicao(i).getQuantidade()
                );
                System.out.println(linhaCardapio);
            }
        }
        System.out.println("---------------------------------------------");
    }

    public static void exibirListaDeIngredientes() {
        System.out.println("---------------------------------------------");
        System.out.println(String.format("| %-3s %-20s %-10s %-5s |", 
            "Cod", "Nome", "Preço", "Quant"));
        for (int i = 0; i < IngredientesController.quantidadeTotalDeIngredientes(); i++) {
            if (IngredientesController.buscaIngredientePorPosicao(i).getQuantidade() > 0) {
                String linhaIngrediente = String.format("| %-3d %-20s R$%-8.2f %-5d |", 
                    i,
                    IngredientesController.buscaIngredientePorPosicao(i).getNome(),
                    IngredientesController.buscaIngredientePorPosicao(i).getPrecoUnitario(),
                    IngredientesController.buscaIngredientePorPosicao(i).getQuantidade()
                );
                System.out.println(linhaIngrediente);
            }
        }
        System.out.println("---------------------------------------------");
    }

    public static void adicionarProduto() {
        System.out.print("Digite o nome do novo produto: ");
        String nome = in.nextLine();

        System.out.print("Quantidade que será adicionada: ");
        int quantidade = Integer.parseInt(in.nextLine());

        System.out.print("Valor unitário do produto: ");
        double valor = Double.parseDouble(in.nextLine());

        Produto produto = new Produto(nome, quantidade, valor);
        ProdutoController.criarProduto(produto);

        System.out.println("Produto " + nome + " criado com sucesso!");
        exibirListaDeProdutos();
    }

    private static int buscaPosicaoDoProduto(String pergunta) {
        exibirListaDeProdutos();
        int posicaoProduto = Utilitarios.recebeOpcaoNumerica(
            pergunta,
            ProdutoController.quantidadeDeProdutos());
        return posicaoProduto;
    }

    public static void adicionaQuantidadeAProduto() {
        int posicaoDoProduto = buscaPosicaoDoProduto(
            "Qual produto deseja adiciona a quantidade?\n(Digite o numero do produto na tabela)");
        int quantidade = Utilitarios.recebeOpcaoNumerica(
            "Qual quantiade deseja adicionar?", 
            9999
        );

        ProdutoController.adicionaQuantidadeAProdutos(posicaoDoProduto, quantidade);
        System.out.println("Quantidade adicionada ao produto " + ProdutoController.buscaProdutoPorPosicao(posicaoDoProduto).getNome());
        exibirListaDeProdutos();
    }

    public static void removerProdutoDoEstoque() {
        int posicaoDoProduto = buscaPosicaoDoProduto(
            "Qual produto deseja excluir\n(Digite o numero do produto na tabela)"
        );
        Produto produto = ProdutoController.buscaProdutoPorPosicao(posicaoDoProduto);
        if (produto.getQuantidade() > 0) {
            System.out.println("Esse produto possui quantidade no estoque e não pode ser removido da lista");
        } else {
            int opcao = Utilitarios.recebeOpcaoNumerica(
                "Tem certeza que deseja excluir o produto?\n0- Sim\n1- Não", 2
            );
            if (opcao == 0) {
                ProdutoController.removerProduto(produto);
                System.out.println("Produto removido do sistema com sucesso");
            } else if (opcao == 1) {
                System.out.println("O produto não foi excluido");
            }
        }
    }
}
