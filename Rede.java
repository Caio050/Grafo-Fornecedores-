

public class Rede {
    
   

    public static <Vertice> void main(String[] args) {


     Grafo grafo = new Grafo();

     //adionando local
     Vertice fabricaSp = new Vertice("FabricaSp");
     Vertice fornecedorCentro = new Vertice("fornecedorCentro");
     Vertice fabricaNordeste = new Vertice("fabricaNordeste");
     Vertice fabricaLitoral = new Vertice("fabricaLitoral");
     Vertice fornecedorOeste = new Vertice("fornecedorOeste");


     // adiciondo Verfice 
     grafo.adicionarVertice(fabricaSp);
     grafo.adicionarVertice(fornecedorCentro);
     grafo.adicionarVertice(fabricaNordeste);
     grafo.adicionarVertice(fornecedorOeste);
     grafo.adicionarVertice(fabricaLitoral);


     // adicionando arrestas e conexoes 
     grafo.adicionarAresta(fornecedorOeste, fabricaSp, 4);                      //fornecedorOeste -> fabricaSp, 4 horas de viagem 
     grafo.adicionarAresta(fornecedorOeste, fornecedorCentro, 5);              //fornecedorOeste -> fornecedorCentro, 5 horas de viagem
     grafo.adicionarAresta(fabricaSp, fabricaNordeste, 10);                   //fabricaSp -> fabricaNordeste -> fornecedorOeste, 10 horas de viagem 
     grafo.adicionarAresta(fabricaLitoral, fabricaSp, 3);                    //fabricaLitoral -> fabricaSp, 3 horas de viagem 

     // Exibir estrutura do grafo
     System.out.println("Exibir informações sobre a viagem");
     grafo.exibirGrafo();


        

    


    }

    
}
 