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
		Scanner keyborad = new Scanner(System.in);
		nome = keyborad.nextLine();	
		
		String comando = "";
		while(!comando.equals("q"))
		{
			heroi.cav.verEstadosCaverna();
			System.out.println("Player: " + nome);
			System.out.println("Score: 0");
			
			System.out.println("\nINFORME SEU MOVIMENTO:");
			
			keyborad = new Scanner(System.in);
			comando = keyborad.nextLine();
			System.out.println();
			
			
		}		
		System.out.println("FIM DE JOGO!!!\n");
	}
}
