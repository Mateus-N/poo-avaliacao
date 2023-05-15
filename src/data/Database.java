package data;

import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import Models.Funcionario;
import Models.Pedido;
import Models.Produto;

public class Database {
    private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private static List<Produto> produtos = new ArrayList<Produto>();
    private static List<Cliente> clientes = new ArrayList<Cliente>();
    private static List<Pedido> pedidos = new ArrayList<Pedido>();
    private static List<Produto> ingredientes = new ArrayList<Produto>();

    static {
        Funcionario[] funcionariosBase = {
            new Funcionario("Remy", "Chefe", 1200, "8:00 > 12:00 | 14:00 > 16:00"),
            new Funcionario("Linguini", "Cozinheiro", 900, "8:00 > 12:00 | 14:00 > 16:00"),
            new Funcionario("Colette", "Cozinheiro", 1200, "8:00 > 12:00 | 14:00 > 16:00")
        };

        for (Funcionario funcionario : funcionariosBase) {
            funcionarios.add(funcionario);
        }

        Produto[] produtosbase = {
            new Produto("Hamburger", 100, 10),
            new Produto("Batata Frita", 60, 12),
            new Produto("Milkshake", 80, 8),
            new Produto("Coca", 90, 4)
        };

        for (Produto item : produtosbase) {
            produtos.add(item);
        }

        Cliente[] clientesBase = {
            new Cliente("Mateus", "Bivar", "123456789"),
            new Cliente("Adrielly", "Bivar", "123456789"),
            new Cliente("Jesus", "Alto BH", "123456789")
        };

        for (Cliente cliente : clientesBase) {
            clientes.add(cliente);
        }

        Produto[] ingredientesBase = {
            new Produto("Pão", 30, 1),
            new Produto("Carne", 30, 5),
            new Produto("Alface", 30, 0.5),
            new Produto("Tomate", 30, 0.5),
            new Produto("Queijo", 30, 2),
            new Produto("Presunto", 30, 3),
            new Produto("Frango", 30, 4),
        };

        for (Produto ingrediente : ingredientesBase) {
            ingredientes.add(ingrediente);
        }
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public static List<Produto> getProdutos() {
        return produtos;
    }
    public static List<Cliente> getClientes() {
        return clientes;
    }
    public static List<Pedido> getPedidos() {
        return pedidos;
    }
    public static List<Produto> getIngredientes() {
        return ingredientes;
    }
}
