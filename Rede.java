import java.util.Scanner;

public class Rede {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grafo grafo = new Grafo();

        // 🏭 Adiciona as fábricas (vértices)
        Vertice sp = new Vertice("Fábrica SP");
        Vertice ceara = new Vertice("Fábrica Ceará");
        Vertice parana = new Vertice("Fábrica Paraná");
        Vertice santos = new Vertice("Fábrica Santos");
        Vertice para = new Vertice("Fábrica Pará");
        Vertice minas = new Vertice("Fábrica Minas");
        Vertice rio = new Vertice("Fábrica Rio de Janeiro");
        Vertice bahia = new Vertice("Fábrica Bahia");
        Vertice acre = new Vertice("Fábrica Acre");

        grafo.adicionarVertice(sp);
        grafo.adicionarVertice(ceara);
        grafo.adicionarVertice(parana);
        grafo.adicionarVertice(santos);
        grafo.adicionarVertice(para);
        grafo.adicionarVertice(minas);
        grafo.adicionarVertice(rio);
        grafo.adicionarVertice(bahia);
        grafo.adicionarVertice(acre);

        // 🛣️ Ligações com tempo estimado
        grafo.adicionarAresta(new Aresta(sp, santos, 1.5));
        grafo.adicionarAresta(new Aresta(santos, sp, 1.5));
        grafo.adicionarAresta(new Aresta(sp, minas, 2.0));
        grafo.adicionarAresta(new Aresta(minas, sp, 2.0));
        grafo.adicionarAresta(new Aresta(minas, rio, 1.5));
        grafo.adicionarAresta(new Aresta(rio, minas, 1.5));
        grafo.adicionarAresta(new Aresta(sp, parana, 2.5));
        grafo.adicionarAresta(new Aresta(parana, sp, 2.5));
        grafo.adicionarAresta(new Aresta(parana, rio, 2.2));
        grafo.adicionarAresta(new Aresta(rio, parana, 2.2));
        grafo.adicionarAresta(new Aresta(bahia, minas, 3.0));
        grafo.adicionarAresta(new Aresta(minas, bahia, 3.0));
        grafo.adicionarAresta(new Aresta(para, bahia, 4.5));
        grafo.adicionarAresta(new Aresta(bahia, para, 4.5));
        grafo.adicionarAresta(new Aresta(ceara, bahia, 2.8));
        grafo.adicionarAresta(new Aresta(bahia, ceara, 2.8));
        grafo.adicionarAresta(new Aresta(para, acre, 6.0));
        grafo.adicionarAresta(new Aresta(acre, para, 6.0));
        grafo.adicionarAresta(new Aresta(acre, bahia, 7.5));
        grafo.adicionarAresta(new Aresta(bahia, acre, 7.5));

        System.out.println("=== SISTEMA DE ROTAS ENTRE FÁBRICAS ===\n");
        System.out.println("Fábricas disponíveis:");
        for (Vertice v : grafo.getVertices()) {
            System.out.println("- " + v.getNome());
        }

        System.out.print("\nDigite a fábrica de origem: ");
        String origem = sc.nextLine().trim();

        System.out.print("Digite a fábrica de destino: ");
        String destino = sc.nextLine().trim();

        grafo.menorCaminhoDijkstra(origem, destino);

        sc.close();
    }
}
