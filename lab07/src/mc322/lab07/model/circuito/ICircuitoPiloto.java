package mc322.lab07.model.circuito;

import mc322.lab07.model.elemento.Elemento;

public interface ICircuitoPiloto 
{
	public int getMaxLin();
	public int getMaxCol();
	public Elemento getElemento(int lin, int col);
}
