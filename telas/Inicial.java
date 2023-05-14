package telas;

import java.util.Scanner;

import utils.Utilitarios;

public class Inicial {
    private static Scanner in = new Scanner(System.in);

    public static void inicial() {
        System.out.println("\nOlá, bem vindo a nossa Hamburgueria!");
        String pergunta = "Como deseja efetuar login?\n1- Cliente\n2- Funcionario\n3- Encerrar sistema";
        int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 3);
        if (opcao == 1) {
            menuCliente();
        } else if (opcao == 2) {
            menuFuncionario();
        } else if (opcao == 3) {
            System.out.println("Volte sempre!");
        }
    }

    private static void menuCliente() {
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        ClienteService.verificaSeClienteJaTemCadastro(nome);
    }

    private static void menuFuncionario() {
    }
}
