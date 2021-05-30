package mc322.lab07.control.construtor;

public interface IConstrutor extends 
  IRCircuitoConstrutor
, IRControleConstrutor
{
	public void carregarCircuito(int maxLin, int maxCol);
}

