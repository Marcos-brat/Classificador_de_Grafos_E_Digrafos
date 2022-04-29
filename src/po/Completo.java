
package po;


public class Completo {
    
    Grafo graph;

    public Completo(Grafo graph) {
        this.graph = graph;
    }
    
    public boolean valida(){
        
        boolean valida = false;
        
        int num = (this.graph.getVerticesNum()*(this.graph.getVerticesNum()-1)/2);
        
        if(this.graph.getArestasNum()/2 == num)
            valida = true;
        
        return valida;
    }
}
