package telas;

import java.util.List;
import java.util.Scanner;

import Models.Produto;
import controllers.ProdutoController;
import utils.Utilitarios;

public class ProdutoService {
    private static Scanner in = new Scanner(System.in);
    private static List<Produto> produtos = ProdutoController.buscarTodosOsProdutos();

    public static void exibirCardapio() {
        System.out.println("--------------------------------------");
        for (int i = 1; i <= produtos.size(); i++) {
            if (produtos.get(i - 1).getQuantidade() > 0) {
                String linhaCardapio = String.format("| %-3d %-20s R$%-7.2f |", 
                    i,
                    produtos.get(i - 1).getNome(),
                    produtos.get(i - 1).getPrecoUnitario()
                );
                System.out.println(linhaCardapio);
            }
        }
        System.out.println("--------------------------------------");
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
    }

    public static void adicionaQuantidadeAProduto() {
        exibirCardapio();
        int posicaoProduto = Utilitarios.recebeOpcaoNumerica(
            "Qual produto deseja adiciona a quantidade?\n(Digite o numero do produto na tabela)",
            produtos.size()) - 1;
        int quantidade = Utilitarios.recebeOpcaoNumerica(
            "Qual quantiade deseja adicionar?", 
            9999
        );

        ProdutoController.adicionaQuantidadeAProdutos(posicaoProduto, quantidade);
        System.out.println("Quantidade adicionada ao produto " + produtos.get(posicaoProduto).getNome());
    }
}
