
package po;


public class Simples {
    
    public Grafo Graph;
    boolean valida = true;
    
    public Simples(Grafo Graph) {
        this.Graph = Graph;
    }
    
    public boolean validaLaco(){
        
        for (int i = 0; i < this.Graph.getOrigem().size(); i++) {
            if(this.Graph.getOrigenIndex(i) == this.Graph.getDestinoIndex(i))
                valida = false;
        }
        
        return this.valida;
    }
    
    public boolean validaArestaParalela(){
        valida=true;
        for (int i = 0; i < this.Graph.getDestino().size()-1; i++) {
            
            for (int j = i+1; j < this.Graph.getDestino().size(); j++) {
                
                if(this.Graph.getOrigenIndex(i)== this.Graph.getOrigenIndex(j))
                {
                    if(this.Graph.getDestinoIndex(i) == this.Graph.getDestinoIndex(j))
                        valida=false;
                }
            }
        }
        
        
        return this.valida;
    }
    
    
    public boolean validacaoSimples()
    {
        this.valida = this.validaLaco();
        if(!this.valida){
            System.out.println("O Grafo possui laço!!! Portanto não é simples!");
            return this.valida;
        }
        this.valida = this.validaArestaParalela();
        if(!this.valida)
        {
            System.out.println("O Grafo possui arestas paralelas!!! Portanto não é simples!");
            return this.valida;
        }
        else
            return this.valida;
    }
    
}
