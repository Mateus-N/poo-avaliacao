package utils;

import java.util.Scanner;

public class Utilitarios {
    private static Scanner in = new Scanner(System.in);

    public static int recebeOpcaoNumerica(String pergunta, int limite) {
        int opcao = 0;
        while (opcao < 1 || opcao > limite) {
            try {
                System.out.println(pergunta);
                opcao = Integer.parseInt(in.nextLine());
                if (opcao < 1 || opcao > limite) {
                    System.out.println("Escolha uma opção válida!");
                }
            } catch (Exception e) {
                System.out.println("Escolha uma opção válida!");
            }
        }
        return opcao;
    }
}
