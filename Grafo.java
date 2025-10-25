import java.util.*;
import java.text.Normalizer;

public class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    // Função para remover acentos e padronizar string
    private String normalizar(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("\\p{M}", "");
        return str.toLowerCase().trim();
    }

    public Vertice getVerticePorNome(String nome) {
        String nomeNormalizado = normalizar(nome);
        for (Vertice v : vertices) {
            if (normalizar(v.getNome()).equals(nomeNormalizado)) {
                return v;
            }
        }
        return null;
    }

    // -----------------------
    // ALGORITMO DE DIJKSTRA
    // -----------------------
    public void menorCaminhoDijkstra(String nomeOrigem, String nomeDestino) {
        Vertice origem = getVerticePorNome(nomeOrigem);
        Vertice destino = getVerticePorNome(nomeDestino);

        if (origem == null || destino == null) {
            System.out.println("❌ Origem ou destino inválido!");
            return;
        }

        Map<Vertice, Double> distancias = new HashMap<>();
        Map<Vertice, Vertice> anteriores = new HashMap<>();
        Set<Vertice> visitados = new HashSet<>();

        for (Vertice v : vertices) {
            distancias.put(v, Double.POSITIVE_INFINITY);
        }
        distancias.put(origem, 0.0);

        PriorityQueue<Vertice> fila = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            if (!visitados.add(atual)) continue;

            for (Aresta a : arestas) {
                if (a.getOrigem().equals(atual)) {
                    Vertice vizinho = a.getDestino();
                    double novaDist = distancias.get(atual) + a.getHoras();
                    if (novaDist < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDist);
                        anteriores.put(vizinho, atual);
                        fila.add(vizinho);
                    }
                }
            }
        }

        if (distancias.get(destino) == Double.POSITIVE_INFINITY) {
            System.out.println("❌ Não há caminho entre " + nomeOrigem + " e " + nomeDestino);
            return;
        }

        // Reconstruir o caminho
        List<Vertice> caminho = new ArrayList<>();
        for (Vertice v = destino; v != null; v = anteriores.get(v)) {
            caminho.add(v);
        }
        Collections.reverse(caminho);

        System.out.println("\nMelhor rota de " + nomeOrigem + " até " + nomeDestino + ":");
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i).getNome());
            if (i < caminho.size() - 1) System.out.print(" -> ");
        }

        System.out.println("\nTempo total: " + distancias.get(destino) + " horas\n");
    }
}

// Classe Vertice
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

// Classe Aresta
class Aresta {
    private Vertice origem;
    private Vertice destino;
    private double horas;

    public Aresta(Vertice origem, Vertice destino, double horas) {
        this.origem = origem;
        this.destino = destino;
        this.horas = horas;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getHoras() {
        return horas;
    }
}
