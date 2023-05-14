package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date data;
    private List<ItemdoPedido> itens;
    private Cliente cliente;
    private double valorTotal;
    
    public double getValorTotal() {
        return valorTotal;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public List<ItemdoPedido> getItens() {
        return itens;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void adicionaItem(ItemdoPedido item) {
        itens.add(item);
        valorTotal += item.getValorTotal();
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        itens = new ArrayList<ItemdoPedido>();
    }
}
