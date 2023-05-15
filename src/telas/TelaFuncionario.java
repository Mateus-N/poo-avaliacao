package telas;

import Models.Funcionario;
import controllers.FuncionarioController;
import utils.OpcoesMenuFuncionario;
import utils.Utilitarios;
import utils.interfaces.IOpcoesMenuFuncionario;

public class TelaFuncionario {
    private static IOpcoesMenuFuncionario opcoesMenu = new OpcoesMenuFuncionario();

    public static void login(String nome) {
        Funcionario funcionario = FuncionarioController.buscaFuncionario(nome);
        if (funcionario != null) {
            telaInicial(funcionario);
        } else {
            System.out.println("Perdão mas não temos um funcionario com esse nome no cadastro!");
        }
    }

    private static void telaInicial(Funcionario funcionario) {
        System.out.println("Seja bem vindo " + funcionario.getNome() + ", o que deseja?");
        if (funcionario.getCargo().equals("Chefe")) {
            menuChefe(funcionario);
        } else if (funcionario.getCargo().equals("Cozinheiro")) {
            menuCozinheiro(funcionario);
        }
    }

    private static void menuChefe(Funcionario funcionario) {
        while (true) {
            int opcao = Utilitarios.recebeOpcaoNumerica(
                "0- Criar produto\n1- adicionar quantidade de produto\n2- remover produto\n3- listar clientes\n4- listar pedidos\n5- gerar relatório de vendas\n6- Sair", 
                7);
            if (opcao == 0) {
                opcoesMenu.criarProduto();
            } else if (opcao == 1) {
                opcoesMenu.adicionarQuantidadeDeProduto();
            } else if (opcao == 2) {
                opcoesMenu.removerProduto();
            } else if (opcao == 3) {
                opcoesMenu.listarClientes(funcionario);
            } else if (opcao == 4) {
                opcoesMenu.listarPedidos();
            } else if (opcao == 5) {
                opcoesMenu.gerarRelatorioDeVendas();
            } else if (opcao == 6) {
                System.out.println("OBRIGADO!!");
                break;
            }
        }
    }

    private static void menuCozinheiro(Funcionario funcionario) {
        while (true) {
            int opcao = Utilitarios.recebeOpcaoNumerica(
                "0- adicionar quantidade de produto\n1- listar clientes\n2- listar pedidos\n3- Sair", 
                4);
            if (opcao == 0) {
                opcoesMenu.adicionarQuantidadeDeProduto();
            } else if (opcao == 1) {
                opcoesMenu.listarClientes(funcionario);
            } else if (opcao == 2) {
                opcoesMenu.listarPedidos();
            } else if (opcao == 3) {
                System.out.println("OBRIGADO!!");
                break;
            }
        }
    }
}
