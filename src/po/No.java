package po;

import java.util.ArrayList;

public class No {
    private char Origem;
    private ArrayList<Character> Destino;
    private ArrayList<Integer> custo;

    public No(char Origem) {
        this.Origem = Origem;
        this.Destino = new ArrayList<>();
        this.custo = new ArrayList<>();
    }

    public char getOrigem() {
        return Origem;
    }

    public void setOrigem(char Origem) {
        this.Origem = Origem;
    }

    public ArrayList getDestino() {
        return Destino;
    }

    public void setDestino(char Destino) {
        this.Destino.add(Destino);
    }

    public ArrayList getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo.add(custo);
    }
    
    public void exibir(){
        System.out.print("["+this.Origem+"]");
        for (int i = 0; i < this.Destino.size(); i++) {
            System.out.print(" -> ["+this.Destino.get(i)+"]");
            if(!this.custo.isEmpty())
                System.out.print("|["+this.custo.get(i)+"]");
        }
        System.out.println("");
    }
    
    
    
}
