


public class Vertice {
    private Vertice origem;
    private Vertice destino;
    private double horas;

   
    public Vertice(Vertice origem, Vertice destino, double horas) {
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

    @Override
    public String toString() {
        return origem.getNome() + " -> " + destino.getNome() + " (" + horas + ")";
    }

    private String getNome() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    public void adicionarAresta(Aresta a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarAresta'");
    }
}
