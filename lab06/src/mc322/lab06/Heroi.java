package mc322.lab06;

public class Heroi extends Componente
{
	int arrow;
	int gold;
	
	Heroi(int lin, int col, Caverna cav)
	{
		super(lin, col, cav);
		sim = "P";
		arrow = 1;
		gold = 0;
	}
	
	//estado arrow: 0 -> n tem, 1-> tem -> 2 -> equipado
	
}

