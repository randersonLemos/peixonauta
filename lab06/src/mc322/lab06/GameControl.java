package mc322.lab06;

import java.util.Scanner;

public class GameControl {
	Componente heroi = null;
	String nome = null;
	
	GameControl(Componente heroi)
	{
		this.heroi = heroi;
	}
	
	void comecar()
	{	
		System.out.println("INICIO DE JOGO!!!\n");
		
		System.out.println("Qual o seu nome?");
		Scanner keyboard = new Scanner(System.in);
		nome = keyboard.nextLine();	
		
		String comando = "";
		while(!comando.equals("q"))
		{
			heroi.cav.verEstadosCaverna();
			System.out.println("Player: " + nome);
			System.out.println("Score: 0");
			
			System.out.println("\nINFORME SEU MOVIMENTO:");
			
			keyboard = new Scanner(System.in);
			comando = keyboard.nextLine();
			System.out.println();
			
			
			int lin = heroi.lin;
			int col = heroi.col;
			
			if(comando == "w") {
				lin--; //posicao final
				//heroi.cav.atualizarCaverna(heroi.lin, heroi.col, lin, col);
			}
			else if(comando == "s") {
				lin++;
				heroi.cav.atualizarCaverna(heroi.lin, heroi.col, lin, col);
			}
			else if(comando == "d") {
				heroi.col++;
				//heroi.cav.atualizarCaverna();
			}
			else if(comando == "a") {
				heroi.col--;
				//heroi.cav.atualizarCaverna();
			}
			
			
			
			//caso ocorra um dos 4 -> -15 pontos
			
			
			
			else if(comando == "k") {
				//heroi.arrow = 2 "equipar flecha"
				//deve necessariamente se tornar 0 na proxima rodada
				
			}
			else if(comando == "c") {
				Sala sala = heroi.cav.getSala(heroi.lin, heroi.col);
				
				if(sala.temOuro())
				{// heroi.gold = 1
				}
			}
			
		
			//condições de derrota
			Sala sala = new Sala(heroi.lin, heroi.col);
			if(sala.temBuraco()) {
				System.out.println("Buraco!!! Voce perdeu");
				//-1000
				break;
			}
			else if(sala.temWumpus()) {
				//Se tem arco -> luta 50% -> se ganhar? mata wumpus e +500
				
				//caso contraio perde -> -1000 e tem q dar break
			}
			
			//condições de vitoria
			if(heroi.lin == 0 && heroi.col == 0) {
				//se tiver ouro -> ganha -> +1000 -> break
				//continua
			}
			
			sala.foiVisitada();	
			
			
			
		}
		
		
		keyboard.close();
		System.out.println("FIM DE JOGO!!!\n");
	}
}