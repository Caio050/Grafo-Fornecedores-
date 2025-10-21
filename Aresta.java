


public class Aresta<Vertice> {
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
