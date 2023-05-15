package utils;

import java.util.Scanner;

import Models.Cliente;
import controllers.ClienteController;

public class UtilsMenuFuncionario {
    private static Scanner in = new Scanner(System.in);

    private static Cliente buscaCliente() {
        System.out.print("\nDigite o nome do cliente: ");
        String pesquisaNome = in.nextLine();
        return ClienteController.buscaClientePorNome(pesquisaNome);
    }

    public static void exibeTodosOsClientes() {
        for (int i = 0; i < ClienteController.quantidadeDeClientes(); i++) {
            System.out.println(String.format(
                "Nome: %-20s Total em Pedidos: R$%-7.2f", 
                ClienteController.buscaClientePorPosicao(i).getNome(),
                ClienteController.totalDeComprasPorCliente(i)
            ));
        }
    }

    public static void removeCliente() {
        Cliente cliente = buscaCliente();
        
        String pergunta = "\nTem certeza que deseja excluir o cliente " + cliente.getNome() + "?\n0- Sim\n1- Não";
        int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 2);
        if (opcao == 0) {
            System.out.println("Excluindo cliente " + cliente.getNome() + "!");
            ClienteController.removeCliente(cliente);
        } else if (opcao == 1) {
            System.out.println("Cliente não excluido!");
        }
    }
}
