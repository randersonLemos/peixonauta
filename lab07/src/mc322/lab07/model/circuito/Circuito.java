package mc322.lab07.model.circuito;

import mc322.lab07.model.elemento.Elemento;

public class Circuito implements ICircuito{
	private Elemento matriz[][];
	private int maxLin = -1;
	private int maxCol = -1;
	
	public void construirMatrizCircuito(int maxLin, int maxCol)
	{
		matriz = new Elemento [maxLin][maxCol];
		this.maxLin = maxLin;
		this.maxCol = maxCol;
		
		for(int lin=0; lin<maxLin; lin++)
		{
			for(int col=0; col<maxCol; col++)
			{
				matriz[lin][col] = null;
			}
		}
	}
	
	public int getMaxLin()
	{
		return maxLin;
	}
	
	public int getMaxCol()
	{
		return maxCol;
	}
	
	public Elemento getElemento(int lin, int col)
	{
		if(lin >= 0 & lin < maxLin & col >= 0 & col < maxCol)
		{
			return matriz[lin][col];
		}
		return null;		
	}
	
	public void setElemento(Elemento elemento)
	{
		int lin = elemento.getLin();
		int col = elemento.getCol();
		if(lin >= 0 & lin < maxLin & col >= 0 & col < maxCol)
		{
			matriz[lin][col] = elemento;
		}
	}
}
