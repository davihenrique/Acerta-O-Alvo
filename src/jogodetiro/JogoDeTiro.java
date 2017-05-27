
package jogodetiro;
import java.util.Random;
import jogodetiro.CampoDeBatalha;

class TiroAoAlvo{
    int tiros;
    String nome;
    int tam;
    int ax; int ay;

    public TiroAoAlvo(int quadrado, int tiros) {
        this.tam = quadrado;
        this.tiros = tiros;
    }

    public void Joga(String nome) {
        this.nome = nome;
        randomalvo();
        
    }
    
     private void randomalvo(){
    
        Random num = new Random();
        
        ax = -1*tam + num.nextInt(tam+tam)+1;
       
        num = new Random();
        
        ay = -1*tam + num.nextInt(tam+tam)+1;
        
        System.out.println(ax+" "+ay);
        
        

}
    
    
}

public class JogoDeTiro {
   
    public static void main(String[] args) {
       
        TiroAoAlvo jogo = new TiroAoAlvo(100,5);
        
        jogo.Joga("João");
        
        System.out.println("Jogador "+jogo.nome);
        System.out.println("Seu alvo está no intervalo ["+(-1*jogo.tam)+","
                           + "+"+jogo.tam+"]");
        System.out.println("Você tem direito a "+jogo.tiros+" tiros");
        
   
           
    }
    
}
