public class Carrinho {

    private int[] itens;
    // Guarda os números dos itens escolhidos

    private int n;
    // Quantidade de itens atualmente no carrinho

    // ✅ Construtor
    public Carrinho(int tamanho) {

        itens = new int[tamanho];
        // Define um tamanho máximo (ex: 100)

        n = 0;
        // Começa vazio
    }

    // ✅ Adiciona item ao carrinho
    public void adicionarItem(int item) {

        itens[n] = item;
        // Coloca o item na próxima posição disponível

        n++;
        // Aumenta quantidade de itens
    }

    // ✅ Ordena os itens (Bubble Sort)
    public void organizarPedido() {

        for (int i = 0; i < n - 1; i++) {
            // controla quantas vezes o algoritmo roda

            for (int j = 0; j < n - 1 - i; j++) {
                // percorre o vetor comparando pares

                if (itens[j] > itens[j + 1]) {
                    // se o atual for maior que o próximo

                    int temp = itens[j];
                    // guarda o valor temporariamente

                    itens[j] = itens[j + 1];
                    // move o menor para esquerda

                    itens[j + 1] = temp;
                    // move o maior para direita
                }
            }
        }
    }

    // ✅ Mostra o carrinho
    public void mostrarCarrinho(Cardapio cardapio) {

        for (int i = 0; i < n; i++) {

            System.out.println("Item " + (i + 1) + ": "
                    + cardapio.getItem(itens[i]));
            // Usa a classe Cardapio para mostrar o nome
        }
    }

    // ✅ Editar item
    public void editar(int posicao, int novoValor) {

        if (posicao >= 1 && posicao <= n) {
            itens[posicao - 1] = novoValor;
            // -1 porque usuário começa em 1
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // ✅ Excluir item
    public void excluir(int posicao) {

        if (posicao >= 1 && posicao <= n) {

            for (int i = posicao - 1; i < n - 1; i++) {
                itens[i] = itens[i + 1];
                // desloca os elementos para esquerda
            }

            n--;
            // reduz a quantidade de itens

        } else {
            System.out.println("Posição inválida!");
        }
    }

    // ✅ Limpar carrinho
    public void limpar() {
        n = 0;
    }
}

