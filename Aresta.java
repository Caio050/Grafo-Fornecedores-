

public class Aresta {
    private Vertice origem; // vértice de onde a aresta começa
    private Vertice destino; // vértice para onde a aresta vai
    private double horas; // peso da aresta (representa tempo/distância em horas)

    public Aresta(Vertice origem, Vertice destino, double horas) { // construtor da aresta
        this.origem = origem; // define o vértice de origem
        this.destino = destino; // define o vértice de destino
        this.horas = horas; // define o valor do peso (horas)
    }

    public Vertice getOrigem() { // retorna o vértice de origem
        return origem;
    }

    public Vertice getDestino() { // retorna o vértice de destino
        return destino;
    }

    public double getHoras() { // retorna o peso da aresta (horas)
        return horas;
    }

    @Override
    public String toString() { // retorna a aresta como texto
        return origem.getNome() + " -> " + destino.getNome() + " (" + horas + "h)";
    }
}
