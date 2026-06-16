import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    // Lista que armazena todos os clientes cadastrados

    private String nome, cpf, senha;
    // Atributos do cliente

    public Cliente() {}

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // ✅ Cadastrar cliente
    public static void cadastrarCliente(Scanner sc) {// passando o scanner como parametro para realizar a leitura dentro do metodo

        Cliente c = new Cliente();
        // Cria um novo objeto cliente

        System.out.print("Nome: ");
        c.setNome(sc.nextLine());

        System.out.print("CPF: ");
        c.setCpf(sc.nextLine());

        System.out.print("Senha: ");
        c.setSenha(sc.nextLine());

        // Verifica se CPF já existe
        for (Cliente cli : clientes) {// cria uma variável cli e  pega um cliente por vez da lista e coloca dentro da variável cli 
            if (cli.getCpf().equals(c.getCpf())) {// se o cpf do cliente inserido for igual ao o que está na variável que percorreu a lista retorna ao cliente
                System.out.println("CPF já cadastrado!");
                return;
            }
        }

        clientes.add(c);
        // Adiciona na lista o cliente 

        System.out.println("Cliente cadastrado!");// Exibe a mensagem para ele 
    }

    //  Login
    public static boolean login(Scanner sc) {

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        for (Cliente c : clientes) {

            if (c.getCpf().equals(cpf) && c.senha.equals(senha)) {
                // Verifica CPF e senha

                System.out.println("Login realizado!");
                return true;
            }
        }

        System.out.println("Dados inválidos!");
        return false;
    }

    // ✅ Alterar dados
    public void alterarDados(Scanner sc) {

        System.out.print("Novo nome: ");
        this.nome = sc.nextLine();

        System.out.print("Nova senha: ");
        this.senha = sc.nextLine();

        System.out.println("Dados atualizados!");
    }

    // ✅ Excluir cliente
    public static void excluirCliente(String cpf) {

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.remove(i);
                System.out.println("Cliente removido!");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }
}
