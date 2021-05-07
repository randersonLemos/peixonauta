package mc322.lab06;

public class Componente {
	String sim = "C";
	
	int lin = -1;
	int col = -1;
	
	Componente(int lin, int col)
	{
		this.lin = lin;
		this.col = col;
	}
	
	String getSim()
	{
		return sim;
	}
	
	/*-componentes:
		Player
		Wumpus
		Ouro
		Buraco
		Brisa
		Fedor
	*/
	//criar cada classe separadamente, essa classe ser� herdeira

}
