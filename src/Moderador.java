public class Moderador {
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