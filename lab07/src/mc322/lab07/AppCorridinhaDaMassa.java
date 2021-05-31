package mc322.lab07;

import mc322.lab07.control.construtor.Construtor;
import mc322.lab07.control.construtor.IConstrutor;
import mc322.lab07.control.controle.Controle;
import mc322.lab07.control.controle.IControle;
import mc322.lab07.model.circuito.Circuito;
import mc322.lab07.model.circuito.ICircuito;
import mc322.lab07.view.circuitovisual.CircuitoVisual;
import mc322.lab07.view.circuitovisual.ICircuitoVisual;

public class AppCorridinhaDaMassa {
	public static void main(String args[])
	{		
		ICircuito icirc = new Circuito();
		IControle icont = new Controle();
		
		IConstrutor icons = new Construtor();
		icons.conectar(icirc);
		icons.conectar(icont);
		
		int maxLin = 18;
		int maxCol = 15;
		icons.carregarCircuito(maxLin, maxCol);
		
		ICircuitoVisual icircVisu = new CircuitoVisual();
		icircVisu.construirJanela(maxLin, maxCol);
		icircVisu.conectar(icirc);
		icont.conectar(icirc);

		//icircVisu.imprimirCircuitoNoConsole();
		//System.out.println();
		icircVisu.atualizarJanela();

		for(int i=0; i<1000; i++)
		{		
			icont.avancarElementosUmaLinhaNoCircuito();
			//icircVisu.imprimirCircuitoNoConsole();
			//System.out.println();
		    icircVisu.atualizarJanela();					
		}
			//IConstrutorApp icons = new Construtor();
		//icons.conectar(circuito);
		//icons.conectar(controle);
		//icons.conectar(circuitoVisual);
		//icons.conectar(painel);

		//icons.conectarComponentes();
		
		//int maxLin = 20;
		//int maxCol = 15;
		//icons.carregarCircuito(maxLin, maxCol);
		
		//circuitoVisual.imprimirCircuitoNoConsole();
		
	}
}