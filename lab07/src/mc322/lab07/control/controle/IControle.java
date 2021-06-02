package mc322.lab07.control.controle;

public interface IControle extends 
  IControleConstrutor 
, IRCircuitoControle
, IRCircuitoVIsualControle
, IRPilotoControle
, IRPilotoVisualControle
{
	public void comecarJogo();
}
