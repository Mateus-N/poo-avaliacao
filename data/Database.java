package data;

import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import Models.Produto;
import Models.funcionarios.Funcionario;
import Models.funcionarios.cargos.Entregador;
import Models.funcionarios.cargos.Ratatouille;


public class Database {
    public static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static List<Produto> produtos = new ArrayList<Produto>();
    public static List<Cliente> clientes = new ArrayList<Cliente>();

    static {
        Funcionario[] funcionariosBase = {
            new Funcionario("Remy", new Ratatouille("Cozinheiro"), 1200, "8:00 > 12:00 | 14:00 > 16:00"),
            new Funcionario("Linguini", new Entregador("Entregador"), 900, "8:00 > 12:00 | 14:00 > 16:00"),
            new Funcionario("Colette", new Entregador("Cozinheira"), 1200, "8:00 > 12:00 | 14:00 > 16:00")
        };

        for (Funcionario funcionario : funcionariosBase) {
            funcionarios.add(funcionario);
        }

        Produto[] produtosbase = {
            new Produto("Hamburger", 100, 10),
            new Produto("Batata Frita", 60, 12),
            new Produto("Milkshake", 50, 8),
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
    }
}
