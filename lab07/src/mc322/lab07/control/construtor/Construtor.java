package mc322.lab07.control.construtor;

import mc322.lab07.control.controle.IControleConstrutor;
import mc322.lab07.model.circuito.ICircuitoConstrutor;
import mc322.lab07.model.elemento.Elemento;
import mc322.lab07.model.elemento.IPilotoConstrutor;
import mc322.lab07.model.elemento.Livre;
import mc322.lab07.model.elemento.Piloto;

public class Construtor implements IConstrutor{
	ICircuitoConstrutor icirc = null;
	IControleConstrutor icont = null;	
	IPilotoConstrutor ipilo = null;
	
	public void conectar(IControleConstrutor icont)
	{
		this.icont = icont;
	}
	
	public void conectar(ICircuitoConstrutor icirc)
	{
		this.icirc = icirc;
	}
	
	public void conectar(IPilotoConstrutor ipilo)
	{
		this.ipilo = ipilo;
	}

	
	public void carregar(int maxLin, int maxCol)
	{	
		icirc.construirMatrizCircuito(maxLin, maxCol);		
		
		for(int lin=0; lin<maxLin; lin++)
		{
			for(int col=0; col<maxCol; col++)
			{
				if(lin < maxLin - 2)
				{
					Elemento elemento = icont.geradorAleatorioDeElementosSemPiloto(lin, col);
					icirc.setElemento(elemento);
				}
				else
				{
					icirc.setElemento(new Livre(lin, col));
				}
			}
		}
		
		ipilo.construirMatrizPiloto(maxLin, maxCol);
		
		/*for(int lin=0; lin<maxLin; lin++)
		{
			for(int col=0; col<maxCol; col++)
			{
				if(!(lin == (maxLin - 1) && col == (maxCol/2)))
				{
					ipilo.setElemento(new Livre(lin, col));
				}
				else
				{
					ipilo.setElemento(new Piloto(lin, col));
				}
			}
		}*/	
	}
}