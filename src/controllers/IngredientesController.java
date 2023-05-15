package controllers;

import java.util.List;

import Models.Produto;
import data.Database;

public class IngredientesController {
    private static List<Produto> ingredientes = Database.getIngredientes();

    public static Produto buscaIngredientePorPosicao(int posicao) {
        return ingredientes.get(posicao);
    }

    public static void removeQuantidadeDeIngrediente(Produto produto, int quantidade) {
        produto.diminuiQuantidade(quantidade);
    }

    public static int quantidadeTotalDeIngredientes() {
        return ingredientes.size();
    }
}
