public class Main {
    public static void main(String[] args) {
        Enciclopedia enciclopedia = new Enciclopedia();
        enciclopedia.adicionarVerbete("A", "este é o verbete A", "Waldyr Soares", "Nubia Catarina");
        enciclopedia.adicionarVerbete("B", "Definição B", "Autor 2", "Revisor 2");


        enciclopedia.exibirDetalhes("A");
        enciclopedia.removerVerbete("B");
        enciclopedia.exibirDetalhes("B");
    }
}