package mc322.lab07.control.construtor;

public interface IConstrutor extends 
  IRCircuitoConstrutor
, IRControleConstrutor
, IRPilotoConstrutor
{
	public void carregarCircuito(int maxLin, int maxCol);
}

