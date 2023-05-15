package Models;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Pedido> historicoDePedidos;

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        historicoDePedidos = new ArrayList<Pedido>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public List<Pedido> getHistoricoDePedidos() {
        return historicoDePedidos;
    }
    public void addPedidoAoHistorico(Pedido pedido) {
        historicoDePedidos.add(pedido);
    }
}
