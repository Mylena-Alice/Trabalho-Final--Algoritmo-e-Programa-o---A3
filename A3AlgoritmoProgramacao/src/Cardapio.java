public class Cardapio {

    private String[] itens;
    // Vetor que guarda todos os nomes dos produtos disponíveis

    //  Construtor
    public Cardapio() {

        itens = new String[] {
                "Pizza", "Hamburguer", "Batata", "Refrigerante", "Suco",
                "Sorvete", "Hot Dog", "Pastel", "Salada", "Lasanha",
                "Arroz", "Feijão", "Frango", "Carne", "Peixe",
                "Sanduiche", "Açaí", "Café", "Chá", "Bolo"
        };
        // Inicializa o cardápio com valores fixos
    }

    // Mostra todos os itens do menu
    public void mostrarMenu() {

        System.out.println("===== CARDÁPIO =====");

        for (int i = 0; i < itens.length; i++) {
            // percorre todas as posições do vetor

            System.out.println((i + 1) + " - " + itens[i]);
            // i+1 → para o usuário (começa em 1)
            // itens[i] → nome do produto
        }
    }

    //  Retorna o nome do item pelo número escolhido
    public String getItem(int indice) {

        if (indice >= 1 && indice <= itens.length) {
            // valida se está dentro do intervalo

            return itens[indice - 1];
            // -1 porque vetor começa em 0
        }

        return "Item inválido";
    }
}

