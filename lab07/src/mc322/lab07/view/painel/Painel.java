package mc322.lab07.view.painel;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import mc322.lab07.model.circuito.ICircuitoPainel;
import mc322.lab07.model.elemento.IPilotoPainel;

public class Painel extends JFrame implements IPainel{	
		private static final long serialVersionUID = 9133938671148624950L;
		private JLabel matriz[][];
		private JLabel ondaDeFogo[];
		private Container contentPane = null;
		private GridBagConstraints c = null;
		ICircuitoPainel icirc = null;
		IPilotoPainel ipilo = null;

		JButton play = null;
		JLabel score = null;
		JLabel status = null;
	
		public void conectar(ICircuitoPainel icirc)
		{
			this.icirc = icirc;
		}
		
		
		public void conectar(IPilotoPainel ipilo)
		{
			this.ipilo = ipilo;
		}
		
		
		public Painel()
		{
			super();
			setSize(1000, 1000);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			contentPane = getContentPane();
			contentPane.setLayout(new GridBagLayout());
			c = new GridBagConstraints();
			
			ImageIcon imagem =  new ImageIcon(
					  new ImageIcon("./textura/play_1.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)
					  );
			
			play = new JButton(imagem);
			score = new JLabel("0");
			status = new JLabel("Bem Vindo");


			
	        //c.fill = GridBagConstraints.BOTH;
	        //c.weightx = 0;
	        //c.weighty = 0;
					
			//setVisible(true);	
		}
		
		
		public void atualizarScore(int valor)
		{
			score.setText("" + valor);
		}
		
		public void atualizarStatus(String mensagem)
		{
			status.setText("" + mensagem);
		}
		
		public void addActionListener(ActionListener I)
		{
	        play.addActionListener(I);
		}
		
		
		public void addKeyListener(KeyListener I)
		{
	        play.addKeyListener(I);
		}
				
		
		public void setMatriz(int maxLin, int maxCol, JLabel matriz[][], JLabel ondaDeFogo[])
		{
			//this.maxLin = maxLin;
			//this.maxCol = maxCol;
			this.matriz = matriz;
			this.ondaDeFogo = ondaDeFogo;
			
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{	
			        c.gridy = lin;
			        c.gridx = col;
			        contentPane.add(matriz[lin][col], c);	
				}
			}
			
			//Onda de fogo atras do carro
			for(int col=0; col<maxCol; col++)
			{	
		        c.gridy = maxLin;
		        c.gridx = col;
		        contentPane.add(ondaDeFogo[col], c);	
			}
			
			//Play
	        c.gridy = maxLin-1;
	        c.gridx = maxCol;
			contentPane.add(play, c);
			
			//Score
	        c.gridy = 0;
	        c.gridx = maxCol;
			contentPane.add(new JLabel("SCORE"), c);
	        c.gridx = maxCol+1;
			contentPane.add(score, c);
			
			//Status
			c.gridy = 5;
	        c.gridx = maxCol;
	        contentPane.add(status, c);
		}
				
		
		public void mostrar()
		{
			setVisible(true);
		}
		
		
		public void atualizarImagemCircuitoPainel()
		{	
			if(icirc != null)
			{
				int maxLin = icirc.getMaxLin();
				int maxCol = icirc.getMaxCol();
				for(int lin=0; lin<maxLin; lin++)
				{
					for(int col=0; col<maxCol; col++)
					{
						ImageIcon imagem = icirc.getElemento(lin, col).getImageIcon();
						atualizarImagem(imagem, lin, col);
					}
				}
			}		
		}
		
		public void atualizarOndaDeFogo()
		{
			int maxCol = icirc.getMaxCol();
			for(int col=0; col<maxCol; col++)
			{
				ImageIcon imagem = new ImageIcon(
						  new ImageIcon("./textura/fogo_4.gif").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)
						  );
				JLabel jlabel = ondaDeFogo[col];
				jlabel.setIcon(imagem);
			}
		}
		
		
		public void atualizarImagemPilotoPainel()
		{
			
			ImageIcon imagem = ipilo.getImageIcon();
			int lin = ipilo.getLin();
			int col = ipilo.getCol();
			if(lin < icirc.getMaxLin())
				atualizarImagem(imagem, lin, col);
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
