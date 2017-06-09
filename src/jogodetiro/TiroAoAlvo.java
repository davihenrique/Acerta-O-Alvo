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
        while (this.tiros > 0) {
            Atirar();
            FimDeJogo();
        }
    }

    private void Apresentar() {
        System.out.println("===================================================");
        System.out.println("Jogador " + this.nomeJogador);
        System.out.println("Seu alvo está no intervalo [" + (-1 * this.tamCampo)
                + ","+ "+" + this.tamCampo + "]");
        System.out.println("Você tem direito a " + tiros + " tiros");
        System.out.println("===================================================");
    }

    private void Atirar() {
        System.out.println("Tiro " + (this.idTiro) + " - entre com o par x y: ");
        Scanner ler = new Scanner(System.in);
        this.pontoX = ler.nextInt();
        ler = new Scanner(System.in);
        this.pontoY = ler.nextInt();
        if (this.pontoX <= this.tamCampo && 
                this.pontoY <= this.tamCampo && 
                this.pontoX >= (-1 * this.tamCampo) && 
                this.pontoY >= (-1 * this.tamCampo)) {
            this.idTiro++;
            Nota();
        } else {
            System.out.println("Erro, Área digitada invalida, tente novamente");
            Atirar();
        }
    }

    private void Nota() {
        float d;
        if (this.pontoX == this.alvoX && this.pontoY == this.alvoY) {
            this.pontos += 100;
        } else {
            d = Distancia(this.pontoX, this.pontoY, this.alvoX, this.alvoY);
            //System.out.println("PONTOS ANTES"+this.pontos);
            if (d < (tamCampo * 5) / 100) {
                this.pontos += this.valorPontoMax / (this.niTiros - 1);
            } else if (d < (tamCampo * 20) / 100) {
                this.pontos += this.valorPontoMax / (this.niTiros * 2);
            } else if (d < (tamCampo * 50) / 100) {
                this.pontos += this.valorPontoMax / (this.niTiros * 3);
            } else if (d < (tamCampo * 80) / 100) {
                this.pontos += this.valorPontoMax / (this.niTiros * 4);
            }
            //System.out.println("PONTOS DEPOIS"+this.pontos);
        }
    }

    private void FimDeJogo() {
        if (pontos >= this.valorPontoMax) {
            this.pontos = 100;
            System.out.println("Arcetou O Alvo faltando " + 
                    (this.niTiros - this.idTiro + 1) + " tiros");
            System.out.println("VC GANHOU");
            System.out.println("Seus pontos: " + this.pontos);
            System.out.println("===================================================");
            tiros = 0;
        } else if (this.tiros > 1) {
            this.tiros--;
            System.out.println("Seus pontos: " + this.pontos);
        } else {
            this.tiros--;
            System.out.println("Fim do Jogo.");
            System.out.println("Jogador " + this.nomeJogador + 
                    ", seu total foi de " + this.pontos + " pontos.");
        }

    }

    private void RandomAlvo() {
        Random num = new Random();
        this.alvoX = -1 * this.tamCampo + num.nextInt(this.tamCampo+
                this.tamCampo) + 1;
        num = new Random();
        alvoY = -1 * this.tamCampo + num.nextInt(this.tamCampo+this.tamCampo)+1;
        System.out.println(this.alvoX + " " + this.alvoY);
    }

    private float Distancia(int xb, int yb, int xa, int ya) {
        float d;
        d = (float) sqrt(((int) pow((xb - xa), 2)) + ((int) pow((yb - ya), 2)));
        return d;
    }
}
