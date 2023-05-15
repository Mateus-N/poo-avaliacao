package telas;

import java.util.List;
import java.util.Scanner;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Pedido;
import controllers.ClienteController;
import controllers.PedidoController;
import utils.Utilitarios;

public class TelaCliente {
    private static Scanner in = new Scanner(System.in);

    public static void verificaSeClienteJaTemCadastro(String nome) {
        Cliente cliente = ClienteController.buscaClientePorNome(nome);
        if (cliente == null) {
            System.out.println("Como um cliente novo, realize o cadastro por favor:");
            cliente = adicionaCliente(nome);
            System.out.println("Cadastro efetuado com sucesso!");
        }
        perfilCliente(cliente);
    }

    private static Cliente adicionaCliente(String nome) {
        System.out.print("Endereço: ");
        String endereco = in.nextLine();

        System.out.print("Telefone: ");
        String telefone = in.nextLine();

        Cliente clienteNovo = new Cliente(nome, endereco, telefone);
        ClienteController.adicionaCliente(clienteNovo);
        return clienteNovo;
    }

    private static void editaCliente(Cliente cliente) {
        String pergunta = "Qual dado deseja alterar?\n0- Nome\n1- Endereco\n2- Telefone";
        int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 3);
        if (opcao == 0) {
            System.out.print("Novo nome: ");
            String nome = in.nextLine();
            cliente.setNome(nome);
        } else if (opcao == 1) {
            System.out.print("Novo endereco: ");
            String endereco = in.nextLine();
            cliente.setEndereco(endereco);
        } else if (opcao == 2) {
            System.out.print("Novo telefone: ");
            String telefone = in.nextLine();
            cliente.setTelefone(telefone);
        }
    }

    private static void perfilCliente(Cliente cliente) {
        while (true) {
            System.out.println("\nSeja bem vindo " + cliente.getNome());
            String pergunta = "O que deseja?\n0- Realizar pedido\n1- Exibir dados pessoais\n2- Exibir histórico de pedidos\n3- Sair";
            int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 4);
            if (opcao == 0) {
                mostraMenuDeProdutos(cliente);
            } else if (opcao == 1) {
                exibeDadosPessoais(cliente);
            } else if (opcao == 2) {
                exibirHistoricoDePedidos(cliente);
            } else if (opcao == 3) {
                System.out.println("VOLTE SEMPRE!!!");
                break;
            }
        }
    }

    private static void mostraMenuDeProdutos(Cliente cliente) {
        int opcao = Utilitarios.recebeOpcaoNumerica(
            "0- Ver cardápio\n1- Montar hambueguer personalizado", 2);
        if (opcao == 0) {
            TelaPedido.fazerPedido(cliente, "cardapio");
        } else if (opcao == 1) {
            TelaPedido.fazerPedido(cliente, "personalizado");
        }
    }

    private static void exibeDadosPessoais(Cliente cliente) {
        System.out.println("\nNome: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        String pergunta = "Deseja editar alguma informacao?\n0- Sim\n1- Não";
        int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 2);
        if (opcao == 0) {
            editaCliente(cliente);
        }
    }

    private static void exibirHistoricoDePedidos(Cliente cliente) {
        List<Pedido> pedidos = cliente.getHistoricoDePedidos();
        System.out.println("\nPedidos do cliente: " + cliente.getNome());
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("---------------------------------------------");
            System.out.println("Pedido Nº" + i);
            exibirItensDoPedido(pedidos.get(i).getItens());
            System.out.println("Total do pedido: " + pedidos.get(i).getValorTotal());
            System.out.println("---------------------------------------------");
        }
        int opcao = Utilitarios.recebeOpcaoNumerica(
            "Deseja cancelar algum pedido?\n0- Sim\n1- Não", 2
        );
        if (opcao == 0) {
            cancelarPedido(pedidos);
        }
    }

    private static void cancelarPedido(List<Pedido> pedidos) {
        int opcao = Utilitarios.recebeOpcaoNumerica(
            "Qual pedido deseja cancela?\n(Digite o Nº do pedido)",
            pedidos.size()
        );
        Pedido pedido = pedidos.remove(opcao);
        PedidoController.cancelaPedido(pedido);
        System.out.println("Pedido de número " + opcao + " cancelado");
    }

    private static void exibirItensDoPedido(List<ItemdoPedido> itens) {
        System.out.println(String.format("| %-20s %-7s %-11s |",
            "Produto", "Quant", "Preço Total"
        ));
        itens.forEach(item -> {
            System.out.println(String.format("| %-20s %-7d R$%-9.2f |",
                item.getProduto().getNome(),
                item.getQuantidade(),
                item.getValorTotal()
            ));
        });
    }
}
