/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodetiro;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author davih
 */
class TiroAoAlvo{
    int tiros;
    String nome;
    int tam;
    int ax; int ay;
    int px; int py;
    float pontos;

    public TiroAoAlvo(int quadrado, int tiros) {
        this.tam = quadrado;
        this.tiros = tiros;
    }

    public void Joga(String nome) {
        this.nome = nome;
        apresentar();
        randomalvo();
        while(this.tiros > 0){
            atirar();
            this.tiros--;
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
        
        System.out.println(px+" "+py);
       
    
}
    
     private void randomalvo(){
    
        Random num = new Random();
        
        ax = -1*tam + num.nextInt(tam+tam)+1;
       
        num = new Random();
        
        ay = -1*tam + num.nextInt(tam+tam)+1;
        
        System.out.println(ax+" "+ay);
}
    
    
}