package mc322.lab07.view.painel;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import mc322.lab07.model.elemento.Piloto;

public class Painel extends JFrame implements IPainel{

	
		private static final long serialVersionUID = 9133938671148624950L;
		private JLabel matriz[][];
		//private int maxLin = -1;
		//private int maxCol = -1;
		protected Container contentPane = null;
		protected GridBagConstraints c = null;
		
		

		public Painel()
		{
			super();
			setSize(1000, 1000);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			contentPane = getContentPane();
			contentPane.setLayout(new GridBagLayout());
			c = new GridBagConstraints();
			
	        //c.fill = GridBagConstraints.BOTH;
	        //c.weightx = 0;
	        //c.weighty = 0;
					
			//setVisible(true);	
		}
		
		public void construirMatrizJLabel(int maxLin, int maxCol)
		{
			matriz = new JLabel[maxLin][maxCol];
			//this.maxLin = maxLin;
			//this.maxCol = maxCol;
			
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
		
		public void atualizarImagem(Piloto piloto, ImageIcon imagem, int lin, int col)
		{
			JLabel jlabel = matriz[lin][col];
			if(!(piloto.getLin() == lin && piloto.getCol() == col))
				jlabel.setIcon(imagem);
			else
				jlabel.setIcon(piloto.getImageIcon());
		}
		
		public void atualizar()
		{
			SwingUtilities.updateComponentTreeUI(this);	
		}
	}
