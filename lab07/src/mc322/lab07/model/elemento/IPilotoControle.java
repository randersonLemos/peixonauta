package mc322.lab07.model.elemento;

public interface IPilotoControle {
	public int getMaxLin();
	public int getMaxCol();
	void setElemento(Elemento elemento);
	public Elemento getElemento(int lin, int col);
}
