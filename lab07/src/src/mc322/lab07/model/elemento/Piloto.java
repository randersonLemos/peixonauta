package mc322.lab07.model.elemento;

import mc322.lab07.model.circuito.ICircuitoPiloto;

public class Piloto extends Elemento implements IPiloto{
	ICircuitoPiloto icirc = null;
	
	
	private String imagemEndereco1 = null; // Normal
	private String imagemEndereco2 = null; // Porcao
	private String imagemEndereco3 = null; // Fogo 
	
	private int poderzin = 0;

	
	public void conectar(ICircuitoPiloto icirc) 
	{
		this.icirc = icirc;
		
	}
	
	
	public Piloto()
	{
		this(-1, -1);
	}

	
	public Piloto(int lin, int col)
	{
		super(lin, col);

		imagemEndereco1 = "./textura/piloto_1.gif";
		imagemEndereco2 = "./textura/piloto_2.gif";
		imagemEndereco3 = "./textura/piloto_3.gif";
		
		setSimbolo("P");
		setImageIcon(imagemEndereco1);
	}
	
	
	public void setImagemIcon1()
	{
		setImageIcon(imagemEndereco1);
	}
	
	
	public void setImagemIcon2()
	{
		setImageIcon(imagemEndereco2);
	}
	
	
	public void setImagemIcon3()
	{
		setImageIcon(imagemEndereco3);
	}
	
	
	
	public void setPosicao(int lin, int col)
	{
		this.setLin(lin);
		this.setCol(col);
	}		

	
	public void moverParaCima()
	{
		
		int lin = this.getLin();
		//int col = this.getCol();
		lin -= 1;
				
		if(lin > 0 & lin < icirc.getMaxLin())
			this.setLin(lin);
	}
	
	
	public void moverParaBaixo()
	{
		int lin = this.getLin();
		//int col = this.getCol();
		lin += 1;
		
		if(lin > 0 & lin < icirc.getMaxLin())
			this.setLin(lin);		
	}
	
	
	public void moverParaEsquerda()
	{
		//int lin = this.getLin();
		int col = this.getCol();
		col -= 1;		
		if(col >= 0 & col < icirc.getMaxCol())
			this.setCol(col);
	}
	
	
	public void moverParaDireita()
	{
		//int lin = this.getLin();
		int col = this.getCol();
		col += 1;
		if(col >= 0 & col < icirc.getMaxCol())
			this.setCol(col);
	}
	
	
	public void setPoderzin(int valor)
	{
		this.poderzin = valor;
	}
	
	public int getPoderzin()
	{
		return this.poderzin;
	}
}
