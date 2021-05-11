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
			
			
			int lin_ant = heroi.lin;
			int col_ant = heroi.col;
			
			//System.out.println("Hero: " + heroi.lin +" "+ heroi.col);
			//System.out.println("Hero: " + lin_ant +" "+ col_ant);

			
			if(comando.equals("w")) 
			{
				int lin_nov = lin_ant - 1;
				int col_nov = col_ant;
				if(lin_nov >= 0 && lin_nov < 4 && col_nov >= 0 && col_nov < 4) {					
					heroi.cav.atualizaSalaDoHeroiNaCaverna(lin_ant, col_ant, lin_nov, col_nov);
				}
			}
			else if(comando.equals("s"))
			{
				int lin_nov = lin_ant + 1;
				int col_nov = col_ant;
				if(lin_nov >= 0 && lin_nov < 4 && col_nov >= 0 && col_nov < 4) {				
					heroi.cav.atualizaSalaDoHeroiNaCaverna(lin_ant, col_ant, lin_nov, col_nov);
				}
			}
			else if(comando.equals("d"))
			{
				int lin_nov = lin_ant;
				int col_nov = col_ant + 1;
				if(lin_nov >= 0 && lin_nov < 4 && col_nov >= 0 && col_nov < 4) {				
					heroi.cav.atualizaSalaDoHeroiNaCaverna(lin_ant, col_ant, lin_nov, col_nov);
				}
			}
			else if(comando.equals("a")) 
			{
				int lin_nov = lin_ant;
				int col_nov = col_ant - 1;
				if(lin_nov >= 0 && lin_nov < 4 && col_nov >= 0 && col_nov < 4) {			
					heroi.cav.atualizaSalaDoHeroiNaCaverna(lin_ant, col_ant, lin_nov, col_nov);
				}
			}
			else 
			{
				System.out.println("Comando não mapeado: " + comando);
			}
			
			
			
			//caso ocorra um dos 4 -> -15 pontos
			
			
			
			//else if(comando == "k") {
				//heroi.arrow = 2 "equipar flecha"
				//deve necessariamente se tornar 0 na proxima rodada
				
			//}
			//else if(comando == "c") {
			//	Sala sala = heroi.cav.getSala(heroi.lin, heroi.col);
			//	
			//	if(sala.temOuro())
			//	{// heroi.gold = 1
			//	}
			//}
			
		
			//condi��es de derrota
			//Sala sala = new Sala(heroi.lin, heroi.col);
			//if(sala.temBuraco()) {
			//	System.out.println("Buraco!!! Voce perdeu");
				//-1000
		//		break;
		//	}
		//	else if(sala.temWumpus()) {
				//Se tem arco -> luta 50% -> se ganhar? mata wumpus e +500
				
				//caso contraio perde -> -1000 e tem q dar break
		//	}
			
			//condi��es de vitoria
		//	if(heroi.lin == 0 && heroi.col == 0) {
				//se tiver ouro -> ganha -> +1000 -> break
				//continua
		//	}
			
		//	sala.foiVisitada();	
			
			
			
		}
		
		
		keyboard.close();
		System.out.println("FIM DE JOGO!!!\n");
	}
}