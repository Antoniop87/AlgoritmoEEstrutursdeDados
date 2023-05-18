public class Node {
    public String verbete;
    public String definicao;
    public String autor;
    public String revisor;
    public Node proximo;

    public Node(String verbete, String definicao, String autor, String revisor) {
        this.verbete = verbete;
        this.definicao = definicao;
        this.autor = autor;
        this.revisor = revisor;
        this.proximo = null;
    }
}
