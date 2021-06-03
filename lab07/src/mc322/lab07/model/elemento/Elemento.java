package mc322.lab07.model.elemento;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Elemento {
	private int lin = -1;
	private int col = -1;
	private String simbolo = null;
	private ImageIcon imagem = null;
	private int xWidth = 50;
	private int yWidth = 50;
	
	Elemento(int lin, int col)
	{
		this.lin = lin;
		this.col = col;
	}
	
	public int getLin()
	{
		return lin;
	}
	
	public void setLin(int lin)
	{
		this.lin = lin;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public void setCol(int col)
	{
		this.col = col;
	}
	
	public String getSimbolo()
	{
		return simbolo;
	}
	
	public void setSimbolo(String simbolo)
	{
		this.simbolo = simbolo;
	}
	
	public ImageIcon getImageIcon()
	{
		return imagem;
	}
	
	public void setImageIcon(String path)
	{
		imagem =  new ImageIcon(
				  new ImageIcon(path).getImage().getScaledInstance(xWidth, yWidth, Image.SCALE_DEFAULT)
				  );
	}
}
