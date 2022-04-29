
package po;

import java.util.ArrayList;


public class Matrizes {
    
    Grafo Graph;
    int matrizMA[][], matrizMI[][];
    ArrayList<No> Lista;

    public Matrizes(Grafo Graph) {
        this.Graph = Graph;
        constroiLista();
    }
    
    public void constroiMA()
    {
        this.matrizMA = new int[Graph.getVerticesNum()][Graph.getVerticesNum()];
        
        for (int i = 0; i < Graph.getVerticesNum(); i++) {
            for (int j = 0; j < Graph.getVerticesNum(); j++) {
                this.matrizMA[i][j] = this.Graph.existeligacao(this.Graph.getVertices().get(i).toLowerCase().charAt(0),this.Graph.getVertices().get(j).toLowerCase().charAt(0));   
            }
        }
    }
    
    public void constroiMI()
    {
        this.matrizMI = new int[Graph.getVerticesNum()][Graph.getArestasNum()]; 
        if(this.Graph.getGrafooudigrafo() == 1){
            if(Graph.valores.isEmpty()){
                for (int i = 0; i < Graph.getVerticesNum(); i++) {
                    for (int j = 0,ja=0; j < Graph.getDestino().size(); j+=2,ja++) {
                        if(Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.origem.get(j) || Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.destino.get(j)){
                            this.matrizMI[i][ja] = 1;
                        }
                    }
                }
            }
            else{
                for (int i = 0; i < Graph.getVerticesNum(); i++) {
                    for (int j = 0,ja=0; j < Graph.getDestino().size(); j+=2,ja++) {
                        if(Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.origem.get(j) || Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.destino.get(j)){
                            this.matrizMI[i][ja] = Graph.getValoresIndex(ja);
                        }
                    }
                }
            }
        }
        else{
            if(Graph.valores.isEmpty()){
                for (int i = 0; i < Graph.getVerticesNum(); i++) {
                    for (int j = 0; j < Graph.getDestino().size(); j++) {
                        if(Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.origem.get(j)){
                            this.matrizMI[i][j] = -1;
                        }
                        else{
                            if(Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.destino.get(j)){
                                this.matrizMI[i][j] = 1;
                            }
                            else{
                                this.matrizMI[i][j] = 0;
                            }
                        }
                    }
                }
            }
            else{
                for (int i = 0; i < Graph.getVerticesNum(); i++) {
                    for (int j = 0; j < Graph.getDestino().size(); j++) {
                        if(Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.origem.get(j)){
                            this.matrizMI[i][j] = Graph.getValoresIndex(j)*-1;
                        }
                        else{
                            if(Graph.Vertices.get(i).toLowerCase().charAt(0) == Graph.destino.get(j)){
                                this.matrizMI[i][j] = Graph.getValoresIndex(j)*1;
                            }
                            else{
                                this.matrizMI[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
    
    //Construir lista ( falta criar a classe lista )
    
    public void constroiLista()
    {
        this.Lista = new ArrayList<No>();
        No aux;
        for (int i = 0; i < Graph.getVerticesNum(); i++) {
           aux = new No(Graph.getVertices().get(i).toLowerCase().charAt(0));
            for (int j = 0; j < Graph.destino.size(); j++) {
                if(Graph.origem.get(j)==aux.getOrigem()){
                    aux.setDestino(Graph.destino.get(j));
                    if(!Graph.getValores().isEmpty()){
                        aux.setCusto(Graph.getValoresIndex(i));
                    }
                }

            }
            Lista.add(aux);
        }
        for (int i = 0; i < Lista.size(); i++) {
            Lista.get(i).exibir();
        }
    }
    
    public void exibeMA(){
        System.out.print("    ");
        for (int i = 0; i < Graph.getVerticesNum(); i++) {
            System.out.print(Graph.getVertices().get(i)+" | ");
        }
        System.out.println("");
        for (int i = 0; i < Graph.getVerticesNum(); i++) {
            System.out.print(Graph.getVertices().get(i)+" | ");
            for (int j = 0; j < Graph.getVerticesNum(); j++) {
                System.out.print(this.matrizMA[i][j]+" | ");
            }
            System.out.println("");
        }
    }
    
    public void exibeMI(){
        System.out.print("   ");
        if(Graph.getGrafooudigrafo() != 1){
            for (int i = 0; i < Graph.getDestino().size(); i++) {
                System.out.print(Graph.getOrigem().get(i)+","+Graph.getDestinoIndex(i)+"|");
            }
        }else{
            for (int i = 0; i < Graph.getDestino().size(); i+=2) {
                System.out.print(Graph.getOrigem().get(i)+","+Graph.getDestinoIndex(i)+"|");
            }
        }
        
        System.out.println("");
        for (int i = 0; i < Graph.getVerticesNum(); i++) {
            System.out.print(Graph.getVertices().get(i)+" | ");
            for (int j = 0; j < Graph.getArestasNum(); j++) {
                System.out.print(this.matrizMI[i][j]+" | ");
            }
            System.out.println("");
        }
    }
        
}
