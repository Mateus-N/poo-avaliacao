package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Models.Produto;
import controllers.ProdutoController;

public class ProdutoTests {
    @Test
    public void testaProdutoController() {
        Produto produto = new Produto("Pastel", 0, 2);
        int quantidadeInicialDeProdutos = ProdutoController.quantidadeDeProdutos();

        ProdutoController.criarProduto(produto);
        int quantidadeDeProdutosAposCriarNovo = ProdutoController.quantidadeDeProdutos();

        assertEquals(quantidadeDeProdutosAposCriarNovo, quantidadeInicialDeProdutos + 1);

        ProdutoController.removerProduto(produto);
        int quantidadeAposRemoverProduto = ProdutoController.quantidadeDeProdutos();
        assertEquals(quantidadeInicialDeProdutos, quantidadeAposRemoverProduto);
    }

    @Test
    public void testaBuscaProdutoPorPosicao() {
        Produto produto = ProdutoController.buscaProdutoPorPosicao(0);
        assertNotNull(produto);
    }
}
