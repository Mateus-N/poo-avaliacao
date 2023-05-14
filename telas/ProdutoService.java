package telas;

import java.util.List;
import java.util.Scanner;

import Models.Produto;
import controllers.ProdutoController;
import utils.Utilitarios;

public class ProdutoService {
    private static Scanner in = new Scanner(System.in);
    private static List<Produto> produtos = ProdutoController.buscarTodosOsProdutos();

    public static void exibirListaDeProdutos() {
        System.out.println("---------------------------------------------");
        System.out.println(String.format("| %-3s %-20s %-10s %-5s |", 
            "Cod", "Nome", "Preço", "Quant"));
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getQuantidade() > 0) {
                String linhaCardapio = String.format("| %-3d %-20s R$%-8.2f %-5d |", 
                    i,
                    produtos.get(i).getNome(),
                    produtos.get(i).getPrecoUnitario(),
                    produtos.get(i).getQuantidade()
                );
                System.out.println(linhaCardapio);
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

    public static void adicionaQuantidadeAProduto() {
        exibirListaDeProdutos();
        int posicaoProduto = Utilitarios.recebeOpcaoNumerica(
            "Qual produto deseja adiciona a quantidade?\n(Digite o numero do produto na tabela)",
            produtos.size());
        int quantidade = Utilitarios.recebeOpcaoNumerica(
            "Qual quantiade deseja adicionar?", 
            9999
        );

        ProdutoController.adicionaQuantidadeAProdutos(posicaoProduto, quantidade);
        System.out.println("Quantidade adicionada ao produto " + produtos.get(posicaoProduto).getNome());
        exibirListaDeProdutos();
    }
}
