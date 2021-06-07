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
		int col = this.getCol();
		lin -= 1;
		
		Elemento elem = icirc.getElemento(lin, col);
		
		if(!(elem.getSimbolo().equals("M")))
			if(lin > 0 & lin < icirc.getMaxLin())
				this.setLin(lin);
	}
	
	
	public void moverParaBaixo()
	{
		int lin = this.getLin();
		int col = this.getCol();
		Elemento elem = icirc.getElemento(lin, col);
		lin += 1;
		
		if(lin > 0 & lin < icirc.getMaxLin()) {
			Elemento elem2 = icirc.getElemento(lin, col);
			if(!(elem2.getSimbolo().equals("M")))
				this.setLin(lin);
		}
		
		else if(lin == icirc.getMaxLin() && elem.getSimbolo().equals("M"))
			this.setLin(lin);
	}
	
	
	public void moverParaEsquerda()
	{
		int lin = this.getLin();
		int col = this.getCol();
		col -= 1;
		Elemento elem = icirc.getElemento(lin, col);
		
		if(!elem.getSimbolo().equals("M"))
			if(col >= 0 & col < icirc.getMaxCol())
				this.setCol(col);
	}
	
	
	public void moverParaDireita()
	{
		int lin = this.getLin();
		int col = this.getCol();
		col += 1;
		Elemento elem = icirc.getElemento(lin, col);
		
		if(!elem.getSimbolo().equals("M"))
			if(col >= 0 & col < icirc.getMaxCol())
				this.setCol(col);
	}
}
