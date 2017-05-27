
package jogodetiro;

import java.util.Random;

public class CampoDeBatalha {
     int x; int y;
     int ax; int ay;
     

    public CampoDeBatalha(int x, int y) {
        this.x = x;
        this.y = y;
        randomalvo();
        
        
    }
    
    private void randomalvo(){
    
        Random num = new Random();
        
        ax = num.nextInt(x)+1;
       
        num = new Random();
        
        ay = num.nextInt(y)+1;
        
        System.out.println(ax+" "+ay);
    
    
}
     
     
     
}
