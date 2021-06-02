package mc322.lab07.model.elemento;

public class Piloto extends Elemento implements IPiloto{
	public Piloto()
	{
		this(-1, -1);
	}

	
	public Piloto(int lin, int col)
	{
		super(lin, col);
		setSimbolo("P");
		setImageIcon("./textura/piloto_1.gif");
	}
	
	
}
