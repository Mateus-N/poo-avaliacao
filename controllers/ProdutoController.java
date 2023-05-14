package controllers;

import java.util.List;

import Models.Produto;
import data.Database;

public class ProdutoController {
    private static List<Produto> produtos = Database.getProdutos();

    public static void criarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> buscarTodosOsProdutos() {
        return produtos;
    }

    public static void adicionaQuantidadeAProdutos(int posicao, int quantidade) {
        if (quantidade > 0) {
            buscaProdutoPorPosicao(posicao).adicionaQuantidade(quantidade);
        }
    }

    public static Produto buscaProdutoPorPosicao(int posicao) {
        return produtos.get(posicao);
    }

    public static void removerProdutos(int posicao) {
        produtos.remove(posicao);
    }

    public static void diminiuQuantidadeNoEstoqueAposVenda(Produto produto, int quantidade) {
        int index = produtos.indexOf(produto);
        produtos.get(index).diminuiQuantidade(quantidade);
    }
}
