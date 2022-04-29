
package po;

import java.util.ArrayList;


public class Regular {
    public Grafo Graph;
    boolean valida = true;

    public Regular(Grafo Graph) {
        this.Graph = Graph;
    }
    
    public boolean validaLista(ArrayList<Character> list){
        
     
        int cont=0;
        ArrayList<Character> lista = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
       
        for (int i = 0; i < list.size(); i++) {
                
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i)== list.get(j))
                {
                    cont++;
                }
            }
            
            if(!list.contains(i)|| list.isEmpty())
            {
                lista.add(list.get(i));
                seq.add(cont);
            }
            cont=0;
        }
        
        for (int i = 0; i < lista.size()-1; i++) {
            
            for (int j = i+1; j < lista.size(); j++) {
                
                if(seq.get(i)!= seq.get(j))
                    this.valida = false;
            }
        }
        
        
       return this.valida;
    }
    
    
    public boolean validaRegular()
    {
        
        if(this.validaLista(this.Graph.getOrigem()))
        {
            System.out.println("Grafo é Regular de emissão!!!");
        }
        if(this.validaLista(this.Graph.getDestino()))
        {
            System.out.println("Grafo é Regular de recepção!!!");
        }
        return this.valida;
    }
}
