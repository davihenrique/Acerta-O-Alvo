
package jogodetiro;
import jogodetiro.CampoDeBatalha;

class TiroAoAlvo{
    int quadrado;
    int tiros;
    String nome;

    public TiroAoAlvo(int quadrado, int tiros) {
        this.quadrado = quadrado;
        this.tiros = tiros;
    }

    public void Joga(String nome) {
        this.nome = nome;
        CampoDeBatalha campo = new CampoDeBatalha(quadrado, quadrado);
        
    }
    
}

public class JogoDeTiro {
   
    public static void main(String[] args) {
       
        TiroAoAlvo jogo = new TiroAoAlvo(100,5);
        
        jogo.Joga("João");
        
        System.out.println("Você tem direito a "+jogo.tiros+" tiros");
           
    }
    
}
