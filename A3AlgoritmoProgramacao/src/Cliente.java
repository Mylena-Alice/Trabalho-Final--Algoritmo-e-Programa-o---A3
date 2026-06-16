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
    public static boolean login(Scanner sc) {// Passando novamente o scanner como parametro

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        for (Cliente c : clientes) {// Novamente insere os clientes dentro de uma variável c, onde puxa as informações do objeto 

            if (c.getCpf().equals(cpf) && c.senha.equals(senha)) {//Verifica se o que está dentro dessa variável é igual ao que o usuário digitou
                // Verifica CPF e senha

                System.out.println("Login realizado!");
                return true;
            }
        }

        System.out.println("Dados inválidos!");
        return false;
    }

    //  Alterar dados
    public void alterarDados(Scanner sc) {// Passa o Scanner como parametro novamente 

        System.out.print("Novo nome: ");
        this.nome = sc.nextLine();

        System.out.print("Nova senha: ");
        this.senha = sc.nextLine();

        System.out.println("Dados atualizados!");
    }

    //  Excluir cliente
    //Realiza uma verificação por CPF do cliente 
    public static void excluirCliente(String cpf) {// passa como parametro o CPF, sendo uma variável local

        for (int i = 0; i < clientes.size(); i++) {// i posição de cada cliente na lista 

            if (clientes.get(i).getCpf().equals(cpf)) {// pega o cliente da posição i e verifica se o CPF é igual ao CPF digitado pelo usuário
                clientes.remove(i);// Se for igual ele remove ele da lista usando a sua posição 
                // A lista é atualizada automaticamente quando usamos add e remove
                System.out.println("Cliente removido!");// Exibe a mensagem 
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }
}
