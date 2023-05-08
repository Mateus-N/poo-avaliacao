import Models.Cliente;
import Models.Produto;
import Models.funcionarios.Funcionario;
import data.Database;

public class Main {
    public static void main(String[] args) {
        for (Produto produto : Database.produtos) {
            System.out.println(produto.getNome());
        }
        System.out.println();
        for (Funcionario func : Database.funcionarios) {
            System.out.println(func.getNome());
        }
        System.out.println();
        for (Cliente cli : Database.clientes) {
            System.out.println(cli.getNome());
        }
    }
}
