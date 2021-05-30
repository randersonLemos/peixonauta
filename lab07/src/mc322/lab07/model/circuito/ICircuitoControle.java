package mc322.lab07.model.circuito;

import mc322.lab07.model.elemento.Elemento;

public interface ICircuitoControle {
	public int getMaxLin();
	public int getMaxCol();
	void setElemento(Elemento elemento);
	public Elemento getElemento(int lin, int col);
}
