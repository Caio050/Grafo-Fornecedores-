import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices; // lista de vértices do grafo
    private List<Aresta> arestas; // lista de arestas do grafo

    public Grafo() { // construtor do grafo
        vertices = new ArrayList<>(); // inicializa a lista de vértices
        arestas = new ArrayList<>(); // inicializa a lista de arestas
    }

    public void adicionarVertice(Vertice vertice) { // adiciona um vértice ao grafo
        vertices.add(vertice);
    }

    public void adicionarAresta(Aresta aresta) { // adiciona uma aresta ao grafo
        arestas.add(aresta);
        aresta.getOrigem().adicionarAresta(aresta); // associa a aresta ao vértice de origem
    }

    public List<Vertice> getVertices() { // retorna a lista de vértices
        return vertices;
    }

    public List<Aresta> getArestas() { // retorna a lista de arestas
        return arestas;
    }

    public Vertice buscarVertice(String nome) { // procura um vértice pelo nome
        for (Vertice v : vertices) { // percorre todos os vértices
            if (v.getNome().equalsIgnoreCase(nome)) { // compara os nomes
                return v; // retorna se encontrar
            }
        }
        return null; // retorna nulo se não achar
    }

    @Override
    public String toString() { // retorna o grafo como texto
        StringBuilder sb = new StringBuilder();
        for (Aresta a : arestas) { // percorre todas as arestas
            sb.append(a.toString()).append("\n"); // adiciona cada aresta no texto
        }
        return sb.toString();
    }
}
