public class Enciclopedia {
    public Node primeiro;
    public Moderador moderador;

    public void adicionarVerbete(String verbete, String definicao, String autor, String revisor) {
        Node novoNode = new Node(verbete, definicao, autor, revisor);

        if (primeiro == null) {
            primeiro = novoNode;
        } else {
            Node atual = primeiro;
            Node anterior = null;

            while (atual != null && verbete.compareTo(atual.verbete) > 0) {
                anterior = atual;
                atual = atual.proximo;
            }

            if (anterior == null) {
                novoNode.proximo = primeiro;
                primeiro = novoNode;
            } else {
                anterior.proximo = novoNode;
                novoNode.proximo = atual;
            }
        }
    }

    public String buscarDefinicao(String verbete) {
        Node atual = primeiro;

        while (atual != null && !atual.verbete.equals(verbete)) {
            atual = atual.proximo;
        }

        if (atual != null) {
            return atual.definicao;
        } else {
            return "Definição não encontrada.";
        }
    }

    public void exibirDetalhes(String verbete) {
        Node atual = primeiro;

        while (atual != null && !atual.verbete.equals(verbete)) {
            atual = atual.proximo;
        }

        if (atual != null) {
            System.out.println("detalhes do verbete: " + atual.verbete);
            System.out.println("definicao: " + atual.definicao);
            System.out.println("autor: " + atual.autor);
            System.out.println("revisor: " + atual.revisor);
        } else {
            System.out.println("verbete não encontrado.");
        }
    }
}

