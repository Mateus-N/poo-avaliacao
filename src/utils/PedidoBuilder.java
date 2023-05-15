package utils;

import java.util.Date;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Pedido;
import Models.Produto;
import controllers.IngredientesController;
import controllers.PedidoController;
import controllers.ProdutoController;

public class PedidoBuilder {
    private Pedido pedido;

    public void iniciarPedido(Cliente cliente) {
        pedido = new Pedido(cliente);
    }

    public void adicionaItemAoPedido(ItemdoPedido item, String cardapioOuPersonalizado) {
        pedido.adicionaItem(item);
        if (cardapioOuPersonalizado == "cardapio") {
            ProdutoController.diminiuQuantidadeNoEstoqueAposVenda(
            item.getProduto(),
            item.getQuantidade()
        );
        } else if (cardapioOuPersonalizado == "personalizado") {
            IngredientesController.removeQuantidadeDeIngrediente(
                item.getProduto(),
                item.getQuantidade()    
            );
        }
        
    }

    public void adicionarTaxaDeEntrega() {
        pedido.adicionaItem(
            new ItemdoPedido(
                new Produto("Entrega", 1, 6), 1)
        );
    }

    public double finalizaPedido() {
        pedido.setData(new Date());
        pedido.getCliente().addPedidoAoHistorico(pedido);
        PedidoController.adicionaPedido(pedido);
        return pedido.getValorTotal();
    }
}
