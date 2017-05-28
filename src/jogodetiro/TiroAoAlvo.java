/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
   private int tiros;private final int itiros;
   private  String nome;
   private final int tam;
   private  int ax;  private int ay;
   private int px;  private int py;
   private  float pontos;


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
            this.tiros--;
            System.out.println("Seus pontos: "+pontos);
        }
        
        
    }
    
    private void apresentar(){
        System.out.println("Jogador "+nome);
        System.out.println("Seu alvo está no intervalo ["+(-1*tam)+","
                           + "+"+tam+"]");
        System.out.println("Você tem direito a "+tiros+" tiros");
        
    }
    
    private void  atirar(){
    
        System.out.println("Tiro "+this.tiros+" - entre com o par x y: ");
        Scanner ler = new Scanner(System.in);
        px = ler.nextInt();
        ler = new Scanner(System.in);
        py = ler.nextInt();
       
        nota();
       
    
}
    
    private void nota(){
        float d;
        
        if(px == ax && py == ay ){
            System.out.println("Arcetou O Alvo faltando "+((tiros-itiros)+1)+" tiros");
            System.out.println("VC GANHOU");
            tiros = 0;
        }else{
            d=distancia(px,py,ax,ay);
            if(d < 10){
                pontos+= 100;
            }else if(d < 30){ 
                pontos+=50;
            }else if (d < 50) {
                pontos+=20;
            }else if(d < 100){
                pontos+=10;
            }
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