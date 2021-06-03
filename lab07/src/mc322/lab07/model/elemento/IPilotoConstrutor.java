package mc322.lab07.model.elemento;

public interface IPilotoConstrutor {
	public void setElemento(Elemento elemento);
	public void setPosicao(int lin, int col);
	public Elemento getElemento(int lin, int col);
	public void construirMatrizPiloto(int maxLin, int maxCol);
}
