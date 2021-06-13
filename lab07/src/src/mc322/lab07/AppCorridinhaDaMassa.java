package mc322.lab07;

import mc322.lab07.control.construtor.Construtor;
import mc322.lab07.control.construtor.IConstrutor;
import mc322.lab07.control.controle.Controle;
import mc322.lab07.control.controle.IControle;
import mc322.lab07.model.circuito.Circuito;
import mc322.lab07.model.circuito.ICircuito;
import mc322.lab07.model.elemento.IPiloto;
import mc322.lab07.model.elemento.Piloto;
import mc322.lab07.view.painel.IPainel;
import mc322.lab07.view.painel.Painel;

public class AppCorridinhaDaMassa {
	public static void main(String args[])
	{		
		IPiloto ipilo = new Piloto();
		ICircuito icirc = new Circuito();
		IControle icont = new Controle();
		IConstrutor icons = new Construtor();
		IPainel ipain = new Painel();		
		
		icons.conectar(ipilo);
		icons.conectar(icirc);
		icons.conectar(icont);
		icons.conectar(ipain);
					
		ipilo.conectar(icirc);
		
		icont.conectar(ipilo);
		icont.conectar(icirc);
		icont.conectar(ipain);
		
		ipain.conectar(ipilo);
		ipain.conectar(icirc);
	
		
		int maxLin = 11;
		int maxCol = 15;
		icons.construir(maxLin, maxCol);

		icont.comecarJogo();
		
	}
}