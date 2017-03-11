import java.util.Scanner;
import java.util.Random;


public class JogoDaVelha {
	    
    char[][] jogoVelha = new char[3][3];
    boolean ganhou = false;
    int jogada = 1;
    char sinal = 'O';
    int linha = 0;
    int coluna = 0;
    boolean jogadaCerta = false;
    int tipoJogo;
    
    Scanner scan = new Scanner(System.in);
    
    void inicializarJogo(){
    	System.out.println("########### JOGO DA VELHA ###########");
    	System.out.println("Escolha as seguintes opcoes:");
    	System.out.println("1. CPU X CPU");
    	System.out.println("2. CPU X PLAYER");
    	System.out.println("3. PLAYER X PLAYER");
    	tipoJogo = scan.nextInt();
    }
    
    void imprimirInicioJogo(){
    	System.out.println("Jogador - 1 = X");
        System.out.println("Jogador - 2 = O");
    }
    
    void imprimirJogoVelha(){
    	System.out.println();
    	for (int i=0; i<jogoVelha.length; i++){
            for (int j=0;j<jogoVelha[i].length; j++){
                System.out.print(jogoVelha[i][j] + " | ");
            }
            System.out.println();
        }
    }
    
    void cpu (){
    	Random gerador = new Random();
    	
    	int resultado = gerador.nextInt(3);
    	
    	System.out.println(resultado);
    	
    }
    
    void jogador1(){
    	System.out.println("Vez do jogador 1. Escolha linha e coluna (1 a 3).");
        sinal = 'X'; 	
    }

    void jogador2(){
    	System.out.println("Vez do jogador 2. Escolha linha e coluna (1 a 3).");
        sinal = 'O'; 
    }
    
    void selecionarLinha(){
    	boolean linhaValida = false;
        while (!linhaValida){
        	if(tipoJogo == 3 || tipoJogo == 2 && sinal == 'O'){
        		System.out.println("Entre com a linha (1, 2 ou 3)");
                linha = scan.nextInt();
                
        	} else if (tipoJogo == 1 || tipoJogo == 2 && sinal == 'X'){
        		Random gerador = new Random();
        		linha = gerador.nextInt(3);
        		linha = linha + 1;
        		System.out.println("Linha: " + linha + " - "+ sinal);
        	}
            
            if (linha >=1 && linha<=3){
                linhaValida = true;
            } else {
                System.out.println("Linha inválida, tente novamente. Linha (1 2 ou 3)");
            }
        }
        linha--;
    }
    
    void selecinarColuna(){
    	boolean colunaValida = false;
        while (!colunaValida){
        	if(tipoJogo == 3 || tipoJogo == 2 && sinal == 'O'){
        		System.out.println("Entre com a coluna (1, 2 ou 3)");
                coluna = scan.nextInt();
        	} else if (tipoJogo == 1 || (tipoJogo == 2 && sinal == 'X')){
        		Random gerador1 = new Random();
        		coluna = gerador1.nextInt(3);
        		coluna = coluna + 1;
        		System.out.println("Coluna: " + coluna + " - "+ sinal);
        		
        	}
        	          
            if (coluna >=1 && coluna<=3){
                colunaValida = true;
            } else {
                System.out.println("Coluna inválida, tente novamente. Coluna (1 2 ou 3");
            }
        }
        coluna--;
    }
    
    void avaliarJogada(){
    	jogadaCerta = false;
    	while (!jogadaCerta)
    	if (jogoVelha[linha][coluna] == 'X' || jogoVelha[linha][coluna] == 'O'){
            System.out.println("Posição já utilizada, tente novamente");
            selecionarLinha();
            selecinarColuna();
        } else { //jogada válida
            jogoVelha[linha][coluna] = sinal;
            jogada++;
            jogadaCerta = true;
        }
    }
    
    void avaliarResultado(){
    	if ((jogoVelha[0][0] == 'X' && jogoVelha[0][1] == 'X' && jogoVelha[0][2] == 'X') ||    
                (jogoVelha[1][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[1][2] == 'X') ||
                (jogoVelha[2][0] == 'X' && jogoVelha[2][1] == 'X' && jogoVelha[2][2] == 'X') ||
                (jogoVelha[0][0] == 'X' && jogoVelha[1][0] == 'X' && jogoVelha[2][0] == 'X') ||
                (jogoVelha[0][1] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][1] == 'X') ||
                (jogoVelha[0][2] == 'X' && jogoVelha[1][2] == 'X' && jogoVelha[2][2] == 'X') ||
                (jogoVelha[0][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][2] == 'X') ||
                (jogoVelha[0][2] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][0] == 'X')){
            ganhou = true;
            System.out.println("Jogador 1 ganhou!");
            
        } else if ((jogoVelha[0][0] == 'O' && jogoVelha[0][1] == 'O' && jogoVelha[0][2] == 'O') ||
                (jogoVelha[1][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[1][2] == 'O') || 
                (jogoVelha[2][0] == 'O' && jogoVelha[2][1] == 'O' && jogoVelha[2][2] == 'O') || 
                (jogoVelha[0][0] == 'O' && jogoVelha[1][0] == 'O' && jogoVelha[2][0] == 'O') || 
                (jogoVelha[0][1] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][1] == 'O') || 
                (jogoVelha[0][2] == 'O' && jogoVelha[1][2] == 'O' && jogoVelha[2][2] == 'O') || 
                (jogoVelha[0][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][2] == 'O') || 
                (jogoVelha[0][2] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][0] == 'O')){  
            ganhou = true;
            System.out.println("Jogador 2 ganhou!");
        } else if (jogada > 9){
            ganhou = true;
            System.out.println("Ninguém ganhou.");
        }
    }
    
}
