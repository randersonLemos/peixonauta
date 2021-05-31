package mc322.lab07.view.circuitovisual;

public interface ICircuitoVisual extends
  ICircuitoVisualPainel
, IRCircuitoCircuitoVisual
{
	public void imprimirCircuitoNoConsole();	
	public void atualizarJanela();
	public void construirJanela(int maxLin, int maxCol);
}
