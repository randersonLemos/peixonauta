package mc322.lab07.control.construtor;

import javax.swing.JLabel;

import mc322.lab07.control.controle.IControleConstrutor;
import mc322.lab07.model.circuito.ICircuitoConstrutor;
import mc322.lab07.model.elemento.Elemento;
import mc322.lab07.model.elemento.IPilotoConstrutor;
import mc322.lab07.model.elemento.Livre;
import mc322.lab07.view.painel.IPainelConstrutor;

public class Construtor implements IConstrutor{
	ICircuitoConstrutor icirc = null;
	IControleConstrutor icont = null;	
	IPilotoConstrutor ipilo = null;
	IPainelConstrutor ipain = null;
	
	
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
	
	
	public void conectar(IPainelConstrutor ipain)
	{
		this.ipain = ipain;
	}

	
	public void construir(int maxLin, int maxCol)
	{	
		{
			Elemento matriz[][] = new Elemento[maxLin][maxCol];
	
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{
					if(lin < maxLin - 2)
					{
						Elemento elemento = icont.geradorAleatorioDeElementosSemPiloto(lin, col);
						matriz[lin][col] = elemento;
					}
					else
					{
						matriz[lin][col] = new Livre(lin, col);
					}
				}
			}		
			icirc.setMatriz(maxLin, maxCol, matriz);
		}	
		
		ipilo.setPosicao(maxLin-1, maxCol/2);	
				
		{
			JLabel matriz[][] = new JLabel[maxLin][maxCol];
			
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{
					JLabel jlabel = new JLabel();
					matriz[lin][col] = jlabel;
				}
			}			
			ipain.setMatriz(maxLin, maxCol, matriz);
		}
	}
}