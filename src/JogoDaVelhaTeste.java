
public class JogoDaVelhaTeste {

	public static void main(String[] args) {
		
		boolean fimDeJogo = false;
		
		JogoDaVelha jogoVelha = new JogoDaVelha();
		
		jogoVelha.inicializarJogo();
		
		jogoVelha.imprimirInicioJogo();
		
		jogoVelha.imprimirJogoVelha();
		
		
		while (!fimDeJogo){
		
		//Selecionar jogador
		if (jogoVelha.sinal == 'O') {
			jogoVelha.jogador1();	
		} else if (jogoVelha.sinal == 'X') {
			jogoVelha.jogador2();			
		}
		
		jogoVelha.selecionarLinha();
		
		jogoVelha.selecinarColuna();
		
		jogoVelha.avaliarJogada();	
		
		jogoVelha.avaliarResultado();
		
		jogoVelha.imprimirJogoVelha();
		
		fimDeJogo = jogoVelha.ganhou;
		}
	}
}
