package jogodetiro;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.Scanner;

class TiroAoAlvo {

    private int tiros;
    private final int niTiros;
    private int idTiro = 1;
    private String nomeJogador;
    private final int tamCampo;
    // alvoX e alvoY é a posição radomizado do alvo.
    private int alvoX;
    private int alvoY;
    // pontoX e PontoY é o ponto digitado pelo usuario.
    private int pontoX;
    private int pontoY;
    private float pontos;
    private final float valorPontoMax = 100;

    public TiroAoAlvo(int quadrado, int tiros) {
        this.tamCampo = quadrado;
        this.tiros = tiros;
        this.niTiros = tiros;
    }

    public void Joga(String nome) {
        this.nomeJogador = nome;
        Apresentar();
        RandomAlvo();
        while (tiros > 0) {
            Atirar();
            FimDeJogo();
        }
    }

    private void Apresentar() {
        System.out.println("===================================================");
        System.out.println("Jogador " + nomeJogador);
        System.out.println("Seu alvo está no intervalo [" + (-1 * tamCampo)
                + ","+ "+" + tamCampo + "]");
        System.out.println("Você tem direito a " + tiros + " tiros");
        System.out.println("===================================================");
    }

    private void Atirar() {
        System.out.println("Tiro " + (idTiro) + " - entre com o par x y: ");
        Scanner scan = new Scanner(System.in);
        pontoX = scan.nextInt();
        pontoY = scan.nextInt();
        //Verifica se o usuario digitou x e y fora do espaço permitido.
        if (pontoX <= tamCampo && 
                pontoY <= tamCampo && 
                pontoX >= (-1 * tamCampo) && 
                pontoY >= (-1 * tamCampo)) {
            idTiro++;
            Nota();
        } else {
            System.out.println("Erro, Área digitada invalida, tente novamente");
            Atirar();
        }
    }

    private void Nota() {
        float d;
        /*
        A pontuação maxima do jogo é 100 pontos, caso o usuario 
        acete posição ele ganha os 100 pontos.
        */
        if (pontoX == alvoX && pontoY == alvoY) {
            pontos += 100;
        } else {
            d = Distancia(pontoX, pontoY, alvoX, alvoY);
            /*
            A regra de pontuação é:
            O jogador ganha o jogo se conseguir chegar a 100 pontos,
            sendo a pontuação máxima.
            Caso o jogador acete em cima do alvo ele já tenha 100 
            pontos e jogo termina.
            
            Caso o jogador acete uma distância 5% de “campo de tiro” 
            entre seu tiro e o alvo ele ganha 100/ números de tiros-1.
            
            Caso o jogador acete uma distância 20% de “campo de tiro” 
            entre seu tiro e o alvo ele ganha 100/ números de tiros-*2.
            
            Caso o jogador acete uma distância 50% de “campo de tiro”
            entre seu tiro e o alvo ele ganha 100/ números de tiros-*3.
            
            Caso o jogador acete uma distância 80% de “campo de tiro” 
            entre seu tiro e o alvo ele ganha 100/ números de tiros-*4.
            
            Assim o valor da pontuação varia e o tamanho do “campo de tiro” 
            e o número de tiros funcionam com para controlar 
            o nível de dificuldade do jogo.
            */
            if (d < (tamCampo * 5) / 100) {
                pontos += valorPontoMax / (niTiros - 1);
            } else if (d < (tamCampo * 20) / 100) {
                pontos += valorPontoMax / (niTiros * 2);
            } else if (d < (tamCampo * 50) / 100) {
                pontos += valorPontoMax / (niTiros * 3);
            } else if (d < (tamCampo * 80) / 100) {
                pontos += valorPontoMax / (niTiros * 4);
            }
            
        }
    }

    private void FimDeJogo() {
        if (pontos >= valorPontoMax) {
            tiros = 0;
            pontos = 100;
            System.out.println("Você conseguiu chegar a "+pontos +" faltando"+ 
                    (niTiros - idTiro + 1) + " tiros");
            System.out.println("VOCÊ GANHOU");
            System.out.println("Seus pontos: " + pontos);
            System.out.println("===================================================");
        } else if (tiros > 1) {
            tiros--;
            System.out.println("Seus pontos: " + pontos);
        } else {
            tiros--;
            System.out.println("Fim do Jogo.");
            System.out.println("Jogador " + nomeJogador + 
                    ", seu total foi de " + pontos + " pontos.");
        }

    }
    //Randomiza o alvo
    private void RandomAlvo() {
        Random num = new Random();
        alvoX = -1 * tamCampo + num.nextInt(tamCampo+
                tamCampo) + 1;
        num = new Random();
        alvoY = -1 * tamCampo + num.nextInt(tamCampo+tamCampo)+1;
        /*
        Comando usando durante o desenvolvimento para mostrar o alvo assim
        que radomizado e retirado na versãofinal do jogo.*/
        System.out.println(alvoX + " " + alvoY);
        
    }
    
    //Calcula a distancia
    private float Distancia(int xb, int yb, int xa, int ya) {
        float d;
        d = (float) sqrt(((int) pow((xb - xa), 2)) + ((int) pow((yb - ya), 2)));
        return d;
    }
}
