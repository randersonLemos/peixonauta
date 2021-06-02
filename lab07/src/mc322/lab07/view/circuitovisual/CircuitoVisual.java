package mc322.lab07.view.circuitovisual;

import javax.swing.ImageIcon;

import mc322.lab07.model.circuito.ICircuitoCircuitoVisual;

public class CircuitoVisual implements ICircuitoVisual{
	ICircuitoCircuitoVisual icirc = null;
	CircuitoVisualJanela janela = new CircuitoVisualJanela();
	
	public void conectar(ICircuitoCircuitoVisual iccircVisu)
	{
		this.icirc = iccircVisu;
	}
	
	public void imprimirCircuitoNoConsole()
	{
		if(icirc != null)
		{
			int maxLin = icirc.getMaxLin();
			int maxCol = icirc.getMaxCol();
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{
					System.out.print(icirc.getElemento(lin,  col).getSimbolo() + " ");					
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
		if(icirc != null)
		{
			int maxLin = icirc.getMaxLin();
			int maxCol = icirc.getMaxCol();
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{
					ImageIcon imagem = icirc.getElemento(lin, col).getImageIcon();
					janela.atualizarImagem(imagem, lin, col);
				}
			}
			janela.atualizar();
		}		
	}
}
