package mc322.lab07.model.circuito;

import mc322.lab07.model.elemento.Elemento;

public interface ICircuitoConstrutor 
{
	void setElemento(Elemento elemento);
	public void construirMatrizCircuito(int maxLin, int maxCol);
}
