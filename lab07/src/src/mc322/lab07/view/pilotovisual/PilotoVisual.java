package mc322.lab07.view.pilotovisual;

import javax.swing.ImageIcon;
import mc322.lab07.model.elemento.IPilotoPilotoVisual;
import mc322.lab07.view.painel.IPainelPilotoVisual;

public class PilotoVisual implements IPilotoVisual{
	
	IPilotoPilotoVisual ipilo = null;
	IPainelPilotoVisual janela = null;
	
	public void conectar(IPilotoPilotoVisual ipilo)
	{
		this.ipilo = ipilo;
	}
	
	public void conectar(IPainelPilotoVisual variavel) {
		this.janela = variavel;
	}
	
	public void imprimirPilotoNoConsole()
	{
		if(ipilo != null)
		{
			int maxLin = ipilo.getMaxLin();
			int maxCol = ipilo.getMaxCol();
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{
					System.out.print(ipilo.getElemento(lin,  col).getSimbolo() + " ");					
				}
				System.out.print("\n");
			}
		}
	}
	
	public void construirJanela(int maxLin, int maxCol)
	{
		janela.construirMatrizJLabel(maxLin, maxCol);
		janela.mostrarJanela();
	}
	
	
	public void atualizarJanela()
	{	
		if(ipilo != null)
		{
			int maxLin = ipilo.getMaxLin();
			int maxCol = ipilo.getMaxCol();
			
				
			ImageIcon imagem = ipilo.getElemento(maxLin-1, maxCol/2).getImageIcon();
			//janela.atualizarImagem(imagem, maxLin-1, maxCol/2);
				
			janela.atualizar();
		}		
	}
	

	
}
