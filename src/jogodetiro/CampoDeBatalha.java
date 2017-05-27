
package jogodetiro;

import java.util.Random;

public class CampoDeBatalha {
     int tam;
     int ax; int ay;
     

    public CampoDeBatalha(int tam) {
        this.tam = tam;
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
