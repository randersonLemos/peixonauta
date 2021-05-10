package mc322.lab06;

public class Componente {
	String sim = "C";
	Caverna cav = null;
	
	int lin = -1;
	int col = -1;
	
	Componente(int lin, int col, Caverna cav)
	{
		this.lin = lin;
		this.col = col;
		this.cav = cav;
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
