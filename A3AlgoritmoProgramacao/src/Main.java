import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Objeto para entrada de dados

        Cardapio cardapio = new Cardapio();
        // Cria o cardápio

        Carrinho carrinho = new Carrinho(100);
        // Cria carrinho com capacidade 100

        while (true) {
            // Loop principal do sistema

            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Comprar");
            System.out.println("5 - Sair");

            int op = sc.nextInt();
            sc.nextLine();
            // lê opção e limpa buffer

            if (op == 1) {
                Cliente.cadastrarCliente(sc);
                // chama cadastro
            }

            else if (op == 2) {

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                for (Cliente c : Cliente.clientes) {
                    if (c.getCpf().equals(cpf)) {
                        c.alterarDados(sc);
                        // altera dados
                        break;
                    }
                }
            }

            else if (op == 3) {

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                Cliente.excluirCliente(cpf);
            }

            else if (op == 4) {

                if (!Cliente.login(sc)) {
                    continue;
                    // volta se login falhar
                }

                carrinho.limpar();
                // esvazia carrinho

                cardapio.mostrarMenu();
                // mostra produtos

                System.out.print("Qtd itens: ");
                int qtd = sc.nextInt();

                for (int i = 0; i < qtd; i++) {
                    System.out.print("Item: ");
                    carrinho.adicionarItem(sc.nextInt());
                }

                carrinho.organizarPedido();
                carrinho.mostrarCarrinho(cardapio);

                String op2;

                do {
                    System.out.print("Editar(E), Excluir(X), Finalizar(V): ");
                    op2 = sc.next();

                    if (op2.equalsIgnoreCase("E")) {
                        int pos = sc.nextInt();
                        int novo = sc.nextInt();

                        carrinho.editar(pos, novo);
                        carrinho.organizarPedido();
                        carrinho.mostrarCarrinho(cardapio);
                    }

                    else if (op2.equalsIgnoreCase("X")) {
                        int pos = sc.nextInt();

                        carrinho.excluir(pos);
                        carrinho.organizarPedido();
                        carrinho.mostrarCarrinho(cardapio);
                    }

                } while (!op2.equalsIgnoreCase("V"));

                System.out.println("Compra finalizada!");
            }

            else if (op == 5) {
                break;
            }
        }

        sc.close();
    }
}
