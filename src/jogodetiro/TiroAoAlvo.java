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
    private int alvoX;
    private int alvoY;
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
        Scanner ler = new Scanner(System.in);
        pontoX = ler.nextInt();
        ler = new Scanner(System.in);
        pontoY = ler.nextInt();
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
        if (pontoX == alvoX && pontoY == alvoY) {
            pontos += 100;
        } else {
            d = Distancia(pontoX, pontoY, alvoX, alvoY);
            //System.out.println("PONTOS ANTES"+pontos);
            if (d < (tamCampo * 5) / 100) {
                pontos += valorPontoMax / (niTiros - 1);
            } else if (d < (tamCampo * 20) / 100) {
                pontos += valorPontoMax / (niTiros * 2);
            } else if (d < (tamCampo * 50) / 100) {
                pontos += valorPontoMax / (niTiros * 3);
            } else if (d < (tamCampo * 80) / 100) {
                pontos += valorPontoMax / (niTiros * 4);
            }
            //System.out.println("PONTOS DEPOIS"+pontos);
        }
    }

    private void FimDeJogo() {
        if (pontos >= valorPontoMax) {
            pontos = 100;
            System.out.println("Arcetou O Alvo faltando " + 
                    (niTiros - idTiro + 1) + " tiros");
            System.out.println("VC GANHOU");
            System.out.println("Seus pontos: " + pontos);
            System.out.println("===================================================");
            tiros = 0;
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

    private void RandomAlvo() {
        Random num = new Random();
        alvoX = -1 * tamCampo + num.nextInt(tamCampo+
                tamCampo) + 1;
        num = new Random();
        alvoY = -1 * tamCampo + num.nextInt(tamCampo+tamCampo)+1;
        System.out.println(alvoX + " " + alvoY);
    }

    private float Distancia(int xb, int yb, int xa, int ya) {
        float d;
        d = (float) sqrt(((int) pow((xb - xa), 2)) + ((int) pow((yb - ya), 2)));
        return d;
    }
}
