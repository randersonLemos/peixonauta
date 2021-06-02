package mc322.lab07;

import mc322.lab07.control.construtor.Construtor;
import mc322.lab07.control.construtor.IConstrutor;
import mc322.lab07.control.controle.Controle;
import mc322.lab07.control.controle.IControle;
import mc322.lab07.model.circuito.Circuito;
import mc322.lab07.model.circuito.ICircuito;
import mc322.lab07.model.elemento.IPiloto;
import mc322.lab07.model.elemento.Piloto;
import mc322.lab07.view.circuitovisual.CircuitoVisual;
import mc322.lab07.view.circuitovisual.ICircuitoVisual;
import mc322.lab07.view.pilotovisual.IPilotoVisual;
import mc322.lab07.view.pilotovisual.PilotoVisual;

public class AppCorridinhaDaMassa {
	public static void main(String args[])
	{		
		IPiloto ipilo = new Piloto();
		ICircuito icirc = new Circuito();
		IControle icont = new Controle();
		IConstrutor icons = new Construtor();
		ICircuitoVisual icircVisu = new CircuitoVisual();	
		IPilotoVisual ipiloVisu = new PilotoVisual();
		
		icons.conectar(ipilo);
		icons.conectar(icirc);
		icons.conectar(icont);
	
		icircVisu.conectar(icirc);
		ipiloVisu.conectar(ipilo);
		
		icont.conectar(ipilo);
		icont.conectar(icirc);
		icont.conectar(icircVisu);
		icont.conectar(ipiloVisu);
		
		int maxLin = 18;
		int maxCol = 15;
		icons.carregarCircuito(maxLin, maxCol);
		icircVisu.construirJanela(maxLin, maxCol);
		icircVisu.atualizarJanela();

		icont.comecarJogo();
	}
}