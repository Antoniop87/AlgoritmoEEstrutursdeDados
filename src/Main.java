public class Main {
    public static void main(String[] args) {
        Enciclopedia enciclopedia = new Enciclopedia();
        enciclopedia.adicionarVerbete("A", "este é o verbete A", "Waldyr Soares", "Nubia Catarina");
        enciclopedia.adicionarVerbete("B", "Definição B", "Autor 2", "Revisor 2");

        Moderador moderador = new Moderador();
        moderador.alterarDefinicao(enciclopedia, "A", "nova definição", "novo revisor");
        enciclopedia.exibirDetalhes("A");
        moderador.removerVerbete(enciclopedia, "B");
        enciclopedia.exibirDetalhes("B");
    }
}