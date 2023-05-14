package telas;

import Models.Cliente;
import utils.PedidoBuilder;

public class PedidoService {

    public static void criarPedido(Cliente cliente) {
        PedidoBuilder builder = new PedidoBuilder();
        builder.iniciarPedido(cliente);
        ProdutoService.exibirCardapio();
        
    }
}
