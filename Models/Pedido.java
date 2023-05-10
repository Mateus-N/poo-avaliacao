package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date data;
    private List<ItemdoPedido> produtos;
    private Cliente cliente;
    private double valorTotal;
    
    public double getValorTotal() {
        return valorTotal;
    }
    public Date getData() {
        return data;
    }
    public List<ItemdoPedido> getProdutos() {
        return produtos;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        produtos = new ArrayList<ItemdoPedido>();
    }


}
