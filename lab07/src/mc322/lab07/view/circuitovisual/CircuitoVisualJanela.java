package mc322.lab07.view.circuitovisual;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import mc322.lab07.model.elemento.Elemento;

public class CircuitoVisualJanela extends JFrame{
	private static final long serialVersionUID = 9133938671148624950L;
	private JLabel matriz[][];
	private int maxLin = -1;
	private int maxCol = -1;
	protected Container contentPane = null;
	protected GridBagConstraints c = null;
	
	

	public CircuitoVisualJanela()
	{
		super();
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 0.1;
        //c.weighty = 0.1;
				
		//setVisible(true);	
	}
	
	public void construirMatrizJLabel(int maxLin, int maxCol)
	{
		matriz = new JLabel[maxLin][maxCol];
		this.maxLin = maxLin;
		this.maxCol = maxCol;
		
		for(int lin=0; lin<maxLin; lin++)
		{
			for(int col=0; col<maxCol; col++)
			{
				JLabel jlabel = new JLabel();
				matriz[lin][col] = jlabel;
				
		        c.gridx = col;
		        c.gridy = lin;
				contentPane.add(jlabel, c);	
			}
		}
	}
	
	public void mostrarJanela()
	{
		setVisible(true);
	}
	
	public void atualizarImagem(ImageIcon imagem, int lin, int col)
	{
		JLabel jlabel = matriz[lin][col];
		jlabel.setIcon(imagem);
	}
	
	public void atualizar()
	{
		SwingUtilities.updateComponentTreeUI(this);	
	}
	
	
}
