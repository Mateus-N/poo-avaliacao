package telas;

import java.util.List;
import java.util.Scanner;

import Models.Cliente;
import Models.ItemdoPedido;
import Models.Pedido;
import controllers.ClienteController;
import utils.Utilitarios;

public class ClienteService {
    private static Scanner in = new Scanner(System.in);

    public static Cliente buscaCliente() {
        System.out.print("\nDigite o nome do cliente: ");
        String pesquisaNome = in.nextLine();
        return ClienteController.buscaClientePorNome(pesquisaNome);
    }

    public static Cliente adicionaCliente(String nome) {
        System.out.print("Endereço: ");
        String endereco = in.nextLine();

        System.out.print("Telefone: ");
        String telefone = in.nextLine();

        Cliente clienteNovo = new Cliente(nome, endereco, telefone);
        ClienteController.adicionaCliente(clienteNovo);
        return clienteNovo;
    }

    public static void editaCliente(Cliente cliente) {
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

    public static void verificaSeClienteJaTemCadastro(String nome) {
        Cliente cliente = ClienteController.buscaClientePorNome(nome);
        if (cliente == null) {
            System.out.println("Como um cliente novo, realize o cadastro por favor:");
            cliente = adicionaCliente(nome);
            System.out.println("Cadastro efetuado com sucesso!");
        }
        perfilCliente(cliente);
    }

    public static void perfilCliente(Cliente cliente) {
        while (true) {
            System.out.println("\nSeja bem vindo " + cliente.getNome());
            String pergunta = "O que deseja?\n0- Realizar pedido\n1- Exibir dados pessoais\n2- Exibir histórico de pedidos\n3- Sair";
            int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 4);
            if (opcao == 0) {
                PedidoService.fazerPedido(cliente);
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

    public static void exibeTodosOsClientes() {
        ClienteController.buscaTodosClientes().forEach(cliente -> {
            System.out.println("Nome: " + cliente.getNome());
        });
    }

    public static void exibeDadosPessoais(Cliente cliente) {
        System.out.println("\nNome: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        String pergunta = "Deseja editar alguma informacao?\n0- Sim\n1- Não";
        int opcao = Utilitarios.recebeOpcaoNumerica(pergunta, 2);
        if (opcao == 0) {
            editaCliente(cliente);
        }
    }

    public static void exibirHistoricoDePedidos(Cliente cliente) {
        List<Pedido> pedidos = cliente.getHistoricoDePedidos();
        System.out.println("\nPedidos do cliente: " + cliente.getNome());
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("---------------------------------------------");
            System.out.println("Pedido Nº" + i);
            exibirItensDoPedido(pedidos.get(i).getItens());
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
        pedidos.remove(opcao);
        System.out.println("Pedido de número " + opcao + " cancelado");
    }

    public static void exibirItensDoPedido(List<ItemdoPedido> itens) {
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
