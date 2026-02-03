package InterfaceLoja;

import ClassBase.Produto;
import Estoque.Estoque;
import Pedido.Pedido;
import SubClasse.Eletronico;
import SubClasse.Livro;
import SubClasse.Roupa;

import java.util.Scanner;

public class InterfaceLoja {
    private Estoque estoque;
    private Scanner scanner = new Scanner(System.in);

    public InterfaceLoja(Estoque estoque) {
        this.estoque = estoque;
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n1. Adicionar Produto\n2. Fazer Pedido\n3. Ver Estoque\n4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    fazerPedido();
                    break;
                case 3:
                    listarEstoque();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarProduto() {
        System.out.println("Tipo (1-Eletrônico, 2-Roupa, 3-Livro):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int qtd = scanner.nextInt();

        Produto p = switch (tipo) {
            case 1 -> new Eletronico(nome, desc, preco, qtd);
            case 2 -> new Roupa(nome, desc, preco, qtd);
            case 3 -> new Livro(nome, desc, preco, qtd);
            default -> null;
        };

        if (p != null) {
            estoque.adicionarProduto(p);
            System.out.println("Produto adicionado com sucesso!");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void fazerPedido() {
        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();
        Pedido pedido = new Pedido(cliente);

        while (true) {
            System.out.print("Nome do produto (ou 'fim'): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) break;

            try {
                Produto p = estoque.buscarProduto(nome);
                System.out.print("Quantidade: ");
                int qtd = scanner.nextInt();
                scanner.nextLine();

                if (qtd > p.getQuantidadeEstoque()) {
                    System.out.println("Estoque insuficiente.");
                } else {
                    pedido.adicionarItem(p, qtd);
                    p.setQuantidadeEstoque(p.getQuantidadeEstoque() - qtd);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Pedido total: R$" + pedido.calcularTotal());
    }

    private void listarEstoque() {
        if (estoque.getProdutos().isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("\n--- ESTOQUE ATUAL ---");
        for (Produto p : estoque.getProdutos().values()) {
            System.out.printf("Nome: %s | Tipo: %s | Preço: R$%.2f | Quantidade: %d\n",
                    p.getNome(), p.getTipo(), p.getPreco(), p.getQuantidadeEstoque());
        }
    }
}
