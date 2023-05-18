public class Enciclopedia {
    private Node primeiro;
    private Moderador moderador;

    private class Node {
        private String verbete;
        private String definicao;
        private String autor;
        private String revisor;
        private Node proximo;

        public Node(String verbete, String definicao, String autor, String revisor) {
            this.verbete = verbete;
            this.definicao = definicao;
            this.autor = autor;
            this.revisor = revisor;
            this.proximo = null;
        }
    }

    private class Moderador {
        public void removerVerbete(Enciclopedia enciclopedia, String verbete) {
            if (enciclopedia.primeiro != null) {
                if (enciclopedia.primeiro.verbete.equals(verbete)) {
                    enciclopedia.primeiro = enciclopedia.primeiro.proximo;
                } else {
                    Node atual = enciclopedia.primeiro;
                    Node anterior = null;

                    while (atual != null && !atual.verbete.equals(verbete)) {
                        anterior = atual;
                        atual = atual.proximo;
                    }

                    if (atual != null) {
                        anterior.proximo = atual.proximo;
                    }
                }
            }
        }

        public void alterarDefinicao(Enciclopedia enciclopedia, String verbete, String novaDefinicao, String novoRevisor) {
            Node atual = enciclopedia.primeiro;

            while (atual != null && !atual.verbete.equals(verbete)) {
                atual = atual.proximo;
            }

            if (atual != null) {
                atual.definicao = novaDefinicao;
                atual.revisor = novoRevisor;
            }
        }
    }

    public Enciclopedia() {
        moderador = new Moderador();
    }

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

    public void removerVerbete(String verbete) {
        moderador.removerVerbete(this, verbete);
    }

    public void alterarDefinicao(String verbete, String novaDefinicao, String novoRevisor) {
        moderador.alterarDefinicao(this, verbete, novaDefinicao, novoRevisor);
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

