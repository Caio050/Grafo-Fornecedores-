import java.util.Objects;

class Vertice {
    private String nome;

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertice)) return false;
        Vertice outro = (Vertice) obj;
        return nome.equals(outro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}