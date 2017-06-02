package jogodetiro;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author davih
 */
class TiroAoAlvo{
   private int tiros;private final int itiros; private int tdados = 1;
   private  String nome;
   private final int tam;
   private  int ax;  private int ay;
   private int px;  private int py;
   private  float pontos;
   private float valorPontoMax = 100;


    public TiroAoAlvo(int quadrado, int tiros) {
        this.tam = quadrado;
        this.tiros = tiros;
        this.itiros = tiros;
    }

    public void Joga(String nome) {
        this.nome = nome;
        apresentar();
        randomalvo();
        while(this.tiros > 0){
            
            atirar();
            verificavitoria();
            
        }
        
        
    }
    
    private void apresentar(){
        System.out.println("Jogador "+nome);
        System.out.println("Seu alvo está no intervalo ["+(-1*tam)+","
                           + "+"+tam+"]");
        System.out.println("Você tem direito a "+tiros+" tiros");
        
    }
    
    private void  atirar(){
    
        System.out.println("Tiro "+(this.tdados++)+" - entre com o par x y: ");
        Scanner ler = new Scanner(System.in);
        px = ler.nextInt();
        ler = new Scanner(System.in);
        py = ler.nextInt();
       
        nota();
       
    
}
    
    private void nota(){
        float d;
        
        if(px == ax && py == ay ){
            
            pontos+= 100;
        }else{
            d=distancia(px,py,ax,ay);
            
            System.out.println("PONTOS ANTES"+this.pontos);
            if(d < (tam*5)/100){
                pontos+= valorPontoMax/(itiros-1);
            }else if (d < (tam*20)/100){ 
                pontos+=valorPontoMax/(itiros*2);
            }else if (d < (tam*50)/100) {
                pontos+=valorPontoMax/(itiros*3);
            }else if(d < (tam*80)/100){
                pontos+=valorPontoMax/(itiros*4);
            }
            System.out.println("PONTOS DEPOIS"+this.pontos);
        }
   
    }
    
    private void verificavitoria(){
        if(pontos >= valorPontoMax){
            this.pontos = 100;
            System.out.println("Arcetou O Alvo faltando "+(this.itiros - this.tdados+1)+" tiros");
            System.out.println("VC GANHOU");
            System.out.println("Seus pontos: "+pontos);
             System.out.println("Seus pontos: "+pontos);
            tiros = 0;
        }else{
            this.tiros--;
            System.out.println("Seus pontos: "+pontos);
        }
        
    }
    
     private void randomalvo(){
    
        Random num = new Random();
        
        ax = -1*tam + num.nextInt(tam+tam)+1;
       
        num = new Random();
        
        ay = -1*tam + num.nextInt(tam+tam)+1;
        
        System.out.println(ax+" "+ay);
}
     private float distancia(int xb, int yb,int xa, int ya){
        float d;
        
        d =  (float) sqrt(((int) pow((xb-xa),2))+((int) pow((yb-ya),2)));
       

        return d;

     }
    
    
}