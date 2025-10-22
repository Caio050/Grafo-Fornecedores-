import java.util.*;

public class Rede extends Grafo { // herda de Grafo
    public Rede() { // construtor da rede
        super(); // chama o construtor da classe pai (Grafo)
    }

    // Algoritmo de Dijkstra para encontrar o menor caminho entre dois vértices
    public Map<Vertice, Double> dijkstra(Vertice origem) {
        Map<Vertice, Double> distancias = new HashMap<>(); // guarda a menor distância até cada vértice
        Set<Vertice> visitados = new HashSet<>(); // guarda os vértices já visitados
        PriorityQueue<Vertice> fila = new PriorityQueue<>(Comparator.comparingDouble(distancias::get)); // fila de prioridade

        for (Vertice v : getVertices()) { // inicializa as distâncias
            distancias.put(v, Double.POSITIVE_INFINITY); // todas começam com infinito
        }
        distancias.put(origem, 0.0); // a origem começa com distância 0
        fila.add(origem); // adiciona a origem na fila

        while (!fila.isEmpty()) { // enquanto houver vértices na fila
            Vertice atual = fila.poll(); // pega o vértice com menor distância
            if (!visitados.add(atual)) continue; // ignora se já foi visitado

            for (Aresta a : atual.getArestas()) { // percorre todas as arestas do vértice atual
                Vertice vizinho = a.getDestino(); // obtém o vértice destino
                double novaDist = distancias.get(atual) + a.getHoras(); // calcula a nova distância

                if (novaDist < distancias.get(vizinho)) { // se for menor que a distância atual
                    distancias.put(vizinho, novaDist); // atualiza a distância
                    fila.add(vizinho); // adiciona o vizinho na fila
                }
            }
        }

        return distancias; // retorna as menores distâncias encontradas
    }

    // Mostra o caminho e distância entre dois vértices usando Dijkstra
    public void mostrarCaminho(Vertice origem, Vertice destino) {
        Map<Vertice, Double> distancias = dijkstra(origem); // executa Dijkstra a partir da origem
        System.out.println("Menor tempo de " + origem.getNome() + " até " + destino.getNome() + ": " 
            + distancias.get(destino) + "h"); // exibe o resultado
    }
}
