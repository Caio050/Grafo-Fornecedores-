import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nome; // nome do vértice (identificador)
    private List<Aresta> arestas; // lista de arestas ligadas a este vértice

    public Vertice(String nome) { // construtor do vértice
        this.nome = nome; // define o nome
        this.arestas = new ArrayList<>(); // inicializa a lista de arestas
    }

    public String getNome() { // retorna o nome do vértice
        return nome;
    }

    public List<Aresta> getArestas() { // retorna todas as arestas do vértice
        return arestas;
    }

    public void adicionarAresta(Aresta aresta) { // adiciona uma aresta à lista
        arestas.add(aresta);
    }

    @Override
    public String toString() { // retorna o nome do vértice como texto
        return nome;
    }
}
