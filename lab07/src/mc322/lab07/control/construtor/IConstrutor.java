package mc322.lab07.control.construtor;

public interface IConstrutor extends 
  IRCircuitoConstrutor
, IRControleConstrutor
, IRPilotoConstrutor
{
	public void carregar(int maxLin, int maxCol);
}

