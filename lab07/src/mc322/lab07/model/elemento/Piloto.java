package mc322.lab07.model.elemento;

import mc322.lab07.model.circuito.ICircuitoPiloto;

public class Piloto extends Elemento implements IPiloto{
	ICircuitoPiloto icirc = null;
	

	public void conectar(ICircuitoPiloto icirc) {
		this.icirc = icirc;
		
	}
	
	
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
	
	
	public void setPosicao(int lin, int col)
	{
		this.setLin(lin);
		this.setCol(col);
	}		

	
	public void moverParaCima()
	{
		int lin = this.getLin();
		lin -= 1;
		if(lin > 0 & lin < icirc.getMaxLin())
			this.setLin(lin);
	}
	
	
	public void moverParaBaixo()
	{
		int lin = this.getLin();
		lin += 1;
		if(lin > 0 & lin < icirc.getMaxLin())
			this.setLin(lin);
	}
	
	
	public void moverParaEsquerda()
	{
		int col = this.getCol();
		col -= 1;
		if(col >= 0 & col < icirc.getMaxCol())
			this.setCol(col);
	}
	
	
	public void moverParaDireita()
	{
		int col = this.getCol();
		col += 1;
		if(col >= 0 & col < icirc.getMaxCol())
			this.setCol(col);
	}
}
