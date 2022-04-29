
package po;

import java.io.IOException;
import java.util.Scanner;


public class PO {

    
    public static void main(String[] args) throws IOException {
        
        Scanner Ler = new Scanner(System.in);
        char[] oriDes = new char[2];
        Grafo grafo = new Grafo();
        int op=0, vertices=0, peso=0;
        String verNome;
        
        
        System.out.println("** Bem-vindo ao classificador de Grafos ***");
                
        do{
            System.out.println("Desejas representar um Grafo ou Dígrafo? (Use 1 para Grafo e 2 para Dígrafo)");
            op = Ler.nextInt();
        }while(op!=1 && op != 2);
        
        //Coleta os dados básicos
        System.out.println("Digite o número de Vértices: ");
        grafo.setVerticesNum(Ler.nextInt());
        System.out.println("Digite o número de Arestas: ");
        grafo.setArestasNum(Ler.nextInt());
        
        
        
        System.out.println("Nomeie os Vértices: (Use apenas carecteres A-Z)");
        
        vertices = grafo.getVerticesNum();
        Ler.nextLine();
        while(vertices > 0){
            System.out.println("Nomeie o vértice número "+(vertices)+": ");
            verNome = Ler.nextLine();
            verNome = verNome.toUpperCase();
            if(verNome.isEmpty()){
                System.out.println("Valor digitado invalido!!!!");
            }
            else
                if(verNome.matches("[A-Z]*"))
                {
                    grafo.setVertices(verNome);
                    vertices-=1;
                }
            
            
        }
        
        // Validação para leitura de valores
        int opc=0;
        do
        {
            System.out.println("Deseja adicionar valor para as arestas? (1 - SIM e 2 - NÃO)");
            opc = Ler.nextInt();
        }while(opc != 1 && opc != 2);

        
        if(op==1)
        {
            System.out.println("Indique as Ligações das arestas no formato: Origem - Desitno");
            int ares = grafo.getArestasNum();
            Ler.nextLine();
            while(ares > 0)
            {

                System.out.println("Indique a Origem:");
                String ori = Ler.nextLine();
                System.out.println("Indique o Destino:");
                String des = Ler.nextLine();
                if(ori.isEmpty() || ori.matches("[A-Z]*") || ori.length()<= 1
                        && des.isEmpty() || des.matches("[A-Z]*") || des.length()<= 1)
                {
                    if(opc == 1)
                    {
                        do{
                            System.out.println("Indique o peso desta aresta: (Apenas números inteiros de 0 a 100)");
                            peso = Integer.parseInt(Ler.nextLine());
                        }while(peso >=100 || peso <= 0);
                        
                        if(peso == (int)peso)
                        {
                            oriDes[0]= ori.charAt(0);
                            oriDes[1]= des.charAt(0);
                            grafo.setOrigem(oriDes[0]);
                            grafo.setDestino(oriDes[1]);
                            grafo.setOrigem(oriDes[1]);
                            grafo.setDestino(oriDes[0]);
                            grafo.setValoresIndex(peso);
                            grafo.setValoresIndex(peso);
                            
                            ares-=1;
                        }
                        else
                            System.out.println("Peso digitado inválidamente!!! Digite novamente.");
                    }
                    else
                    {
                        oriDes[0]= ori.charAt(0);
                        oriDes[1]= des.charAt(0);
                        grafo.setOrigem(oriDes[0]);
                        grafo.setDestino(oriDes[1]);
                        grafo.setOrigem(oriDes[1]);
                        grafo.setDestino(oriDes[0]);
                        ares-=1;
                    }
                }
                else
                    System.out.println("Origem e Destino inseridos incorretamente!!! Digite novamente");
                    
            }
            
        }else
        {         
            System.out.println("Indique as Ligações das arestas no formato: Origem - Desitno");
            int ares = grafo.getArestasNum();
            Ler.nextLine();
            while(ares > 0)
            {

                System.out.println("Indique a Origem:");
                String ori = Ler.nextLine();
                System.out.println("Indique o Destino:");
                String des = Ler.nextLine();
                if(ori.isEmpty() || ori.matches("[A-Z]*") || ori.length()<= 1
                        && des.isEmpty() || des.matches("[A-Z]*") || des.length()<= 1)
                {
                    
                    if(opc == 1)
                    {
                        do{
                            System.out.println("Indique o peso desta aresta: (Apenas números inteiros de 0 a 100)");
                            peso = Integer.parseInt(Ler.nextLine());
                        }while(peso >=100 || peso <= 0);
                        if(peso == (int)peso)
                        {
                            oriDes[0]= ori.charAt(0);
                            oriDes[1]= des.charAt(0);
                            grafo.setOrigem(oriDes[0]);
                            grafo.setDestino(oriDes[1]);
                            grafo.setValoresIndex(peso);
                            ares-=1;
                        }
                        else
                            System.out.println("Peso digitado inválidamente!!! Digite novamente.");
                    }
                    else
                    {
                        oriDes[0]= ori.charAt(0);
                        oriDes[1]= des.charAt(0);
                        grafo.setOrigem(oriDes[0]);
                        grafo.setDestino(oriDes[1]);
                        ares-=1;
                    }
                }
                else
                    System.out.println("Peso digitado inválidamente!!! Digite novamente.");
                
            }
        }
        
        grafo.setGrafooudigrafo(op);
        Simples simpla = new Simples(grafo);
        Completo comp = new Completo(grafo);
        Regular reg = new Regular(grafo);
        Matrizes mat = new Matrizes(grafo);
        
        
        if(simpla.validacaoSimples()){
            System.out.println("Término de verificação: O Grafo/Dígrafo é simples");
        }else{
            if(!simpla.validaLaco() && simpla.validaArestaParalela()){
                mat.constroiMA();
                System.out.println("Matriz de Adjacencia:");
                mat.exibeMA();
            }
            else{
                System.out.println("O Grafo possui arestas paralelas!!! Portanto não é simples!");
            }
        }
        
        mat.constroiMI();
        System.out.println("Matriz de Incidencia:");
        mat.exibeMI();
        
        if(comp.valida())
            System.out.println("Término de verifiação: Grafo/Dígrafo é completo e Regular!!!");
        else
        {
            if(reg.validaRegular()){
                
            }
            else
                System.out.println("Término de verificação: Grafo/Dígrafo não é regular");
                
        }
    }
    
}
