
package po;

import java.util.ArrayList;
import java.util.List;


public class Grafo {
    
    private int arestasNum;
    
    private int verticesNum;
    
    public char oriDes[];    // par de char contendo origem e destino
    
    public ArrayList<String> Vertices; // lista para armazenar os vertices
    
    public ArrayList<Character> origem; // lista para armazenar os pares de oriDes[]
    
    public ArrayList<Character> destino;
    
    public ArrayList<Integer> valores;
    
    private int grafoouDigrafo;


    public Grafo() {
        this.arestasNum = 0;
        this.verticesNum = 0;
        this.Vertices = new ArrayList<>();
        this.origem = new ArrayList<>();
        this.oriDes = new char[2];
        this.destino = new ArrayList<>();
        this.destino = new ArrayList<>();
        this.valores = new ArrayList<>();
    }
    
    
 

    public ArrayList<Character> getOrigem() {
        return origem;
    }

    public void setOrigem(char origem) {
        this.origem.add(origem);
    }

    public ArrayList<Character> getDestino() {
        return destino;
    }

    public void setDestino(char destino) {
        this.destino.add(destino);
    }
    
    public ArrayList<String> getVertices() {
        return Vertices;
    }

    public void setVertices(String ver) {
        this.Vertices.add(ver);
    }
 
    public char[] getOriDes() {
        return oriDes;
    }

    public void setOriDes(char[] oriDes) {
        this.oriDes = oriDes;
    }

    public int getArestasNum() {
        return arestasNum;
    }

    public void setArestasNum(int arestasNum) {
        this.arestasNum = arestasNum;
    }

    public int getVerticesNum() {
        return verticesNum;
    }

    public void setVerticesNum(int verticesNum) {
        this.verticesNum = verticesNum;
    }
    
    public char getOrigenIndex(int index)
    {
        return this.getOrigem().get(index);
    }
    
    public char getDestinoIndex(int index)
    {
        return this.getDestino().get(index);
    }    
    
    public ArrayList<Integer> getValores() {
        return valores;
    }
    
    public void setValoresIndex(int valor)
    {
        this.valores.add(valor);
    }

    public void setValores(ArrayList<Integer> valores) {
        this.valores = valores;
    }
    
    public int getValoresIndex(int index)
    {
        return this.valores.get(index);
    }
    public int existeligacao(char ori, char dest){
        int qtd = 0;
        for(int i = 0; i <this.getOrigem().size();i++){
            if(this.getOrigem().get(i) == ori && this.getDestino().get(i) == dest){
                if(this.valores.isEmpty())
                    qtd++;
                else 
                    qtd+=this.valores.get(i);
            }
        }
        return qtd;
    }

    public int getGrafooudigrafo() {
        return grafoouDigrafo;
    }

    public void setGrafooudigrafo(int grafooudigrafo) {
        this.grafoouDigrafo = grafooudigrafo;
    }
    
    
}
