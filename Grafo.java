
import java.util.*;

public class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarVertice(Vertice v) {
        vertices.add(v);
    }

    public void adicionarAresta(Vertice fabricaLitoral, Vertice fabricaSp, double horas) {
        Aresta a = new Aresta(fabricaLitoral, fabricaSp,horas );
        fabricaLitoral.adicionarAresta(a);
        arestas.add(a);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void exibirGrafo() {
        for (Vertice v : vertices) {
            System.out.print(v.getNome() + " -> ");
            for (Aresta a : v.getArestas()) {
                System.out.print(a.getDestino().getNome() + "(" + a.getHoras() + ") ");
            }
            System.out.println();
        }
    }

    // ðŸ” Busca em Largura (Breadth-First Search)
    public void buscaEmLargura(Vertice inicio) {
        Queue<Vertice> fila = new LinkedList<>();
        Set<Vertice> visitados = new HashSet<>();

        fila.add(inicio);
        visitados.add(inicio);

        System.out.println("\nBusca em Largura a partir de: " + inicio.getNome());

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            System.out.println("Visitando: " + atual.getNome());

            for (Aresta a : atual.getArestas()) {
                Vertice vizinho = a.getDestino();
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }
    }
}

