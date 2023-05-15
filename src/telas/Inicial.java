package telas;

import java.util.Scanner;

import utils.Utilitarios;

public class Inicial {
    private static Scanner in = new Scanner(System.in);

    public static void inicial() {
        while (true) {
            System.out.println("\nOlá, bem vindo a nossa Hamburgueria!");
            String pergunta = "Como deseja efetuar login?\n0- Cliente\n1- Funcionario\n2- Encerrar sistema";
            int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 3);
            if (opcao == 0) {
                menuCliente();
            } else if (opcao == 1) {
                menuFuncionario();
            } else if (opcao == 2) {
                System.out.println("Volte sempre!");
                break;
            }
        }
    }

    private static void menuCliente() {
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        TelaCliente.verificaSeClienteJaTemCadastro(nome);
    }

    private static void menuFuncionario() {
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        TelaFuncionario.login(nome);
    }
}
