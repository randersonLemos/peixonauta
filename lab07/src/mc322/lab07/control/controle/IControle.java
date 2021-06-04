package mc322.lab07.control.controle;

public interface IControle extends 
  IControleConstrutor 
, IRCircuitoControle
, IRPilotoControle
, IRPainelControle 
, IRComandoControle
{
	public void comecarJogo();
}
