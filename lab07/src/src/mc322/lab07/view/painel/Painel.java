package mc322.lab07.view.painel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
		private Container contentPane = null;
		private GridBagConstraints c = null;
		ICircuitoPainel icirc = null;
		IPilotoPainel ipilo = null;

		JButton play = null;
		//JButton reset = null;
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
            setBackground(Color.BLACK);
	
			
			contentPane = getContentPane();
			contentPane.setLayout(new GridBagLayout());
			c = new GridBagConstraints();			
	  			
			ImageIcon imagem =  new ImageIcon(
					  new ImageIcon("./textura/play_1.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)
					  );			
			play = new JButton(imagem);
			play.setBackground(Color.WHITE);

			//imagem =  new ImageIcon(
			//		  new ImageIcon("./textura/reset_1.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)
			//		  );			
			//reset = new JButton(imagem);
			//reset.setBackground(Color.WHITE);
			
			score = new JLabel("0", JLabel.RIGHT);
			score.setFont(new Font("Ariel", Font.PLAIN, 20));

			status = new JLabel("Bem Vindo", JLabel.LEFT);
			status.setFont(new Font("Ariel", Font.PLAIN, 20));
		}
		
		
		public void atualizarScore(int valor)
		{
			score.setText("" + valor);
		}
		
		
		public void atualizarStatus(String mensagem)
		{
			status.setText("" + mensagem);
		}
		
		
		public void addPlayActionListener(ActionListener I)
		{
	        play.addActionListener(I);
		}
		
				
		public void addPlayKeyListener(KeyListener I)
		{
	        play.addKeyListener(I);
		}
		
		
		//public void addResetActionListener(ActionListener I)
		//{
	    //    reset.addActionListener(I);
		//}	
				
		
		public void setMatriz(int maxLin, int maxCol, JLabel matriz[][])
		{

			// Circuito
			this.matriz = matriz;
			
			for(int lin=0; lin<maxLin; lin++)
			{
				for(int col=0; col<maxCol; col++)
				{	
			        c.gridy = lin+1;
			        c.gridx = col;
			        contentPane.add(matriz[lin][col], c);	
				}
			}
			
			// Onda de fogo atras do carro
			ImageIcon imagem = new ImageIcon(
					  new ImageIcon("./textura/fogo_4.gif").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)
					  );
			
			for(int col=0; col<maxCol; col++)
			{	
				JLabel jlabel = new JLabel(imagem);
		        c.gridy = maxLin+1;
		        c.gridx = col;
		        contentPane.add(jlabel, c);	
			}
			
			// Play
	        c.gridy = maxLin+1;
	        c.gridx = maxCol+2;
	        c.gridwidth = 2;
	        contentPane.add(play, c);
	        
			// Reset
	        //c.gridy = maxLin+1;
	        //c.gridx = maxCol+1;
	        //c.gridwidth = 2;
	        //contentPane.add(reset, c);
			
			// Score
	        c.gridy = 0;
	        c.gridx = maxCol-3;
	        c.gridwidth = 3;
	        c.fill = GridBagConstraints.HORIZONTAL;
			contentPane.add(score, c);
			
			// Status
			c.gridy = 0;
	        c.gridx = 0;
	        c.gridwidth = 10;
	        c.fill = GridBagConstraints.HORIZONTAL;
	        contentPane.add(status, c);
	        
	        // Botoes de movimentacao    
			JLabel jlabel = new JLabel("W", JLabel.RIGHT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+2;
	        c.gridx = maxCol/2;
	        c.gridwidth = 1;
	        c.fill = GridBagConstraints.CENTER;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("R", JLabel.RIGHT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+2;
	        c.gridx = maxCol/2 + 1;
	        c.gridwidth = 1;
	        c.fill = GridBagConstraints.CENTER;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("D", JLabel.RIGHT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+3;
	        c.gridx = maxCol/2+1;
	        c.gridwidth = 1;
	        c.fill = GridBagConstraints.CENTER;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("A", JLabel.RIGHT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+3;
	        c.gridx = maxCol/2-1;
	        c.gridwidth = 1;
	        c.fill = GridBagConstraints.CENTER;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("S", JLabel.RIGHT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+3;
	        c.gridx = maxCol/2;
	        c.gridwidth = 1;
	        c.fill = GridBagConstraints.CENTER;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("W: para frente", JLabel.LEFT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+2;
	        c.gridx = 0;
	        c.gridwidth = 5;
	        c.fill = GridBagConstraints.HORIZONTAL;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("D: para direita", JLabel.LEFT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+3;
	        c.gridx = 0;
	        c.gridwidth = 5;
	        c.fill = GridBagConstraints.HORIZONTAL;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("A: para esquerda", JLabel.LEFT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+4;
	        c.gridx = 0;
	        c.gridwidth = 5;
	        c.fill = GridBagConstraints.HORIZONTAL;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("S: para baixo", JLabel.LEFT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+5;
	        c.gridx = 0;
	        c.gridwidth = 5;
	        c.fill = GridBagConstraints.HORIZONTAL;
	        contentPane.add(jlabel, c);
	        
			jlabel = new JLabel("R: para reiniciar", JLabel.LEFT);
			jlabel.setFont(new Font("Ariel", Font.PLAIN, 20));
			c.gridy = maxLin+6;
	        c.gridx = 0;
	        c.gridwidth = 5;
	        c.fill = GridBagConstraints.HORIZONTAL;
	        contentPane.add(jlabel, c);
		}
				
		
		public void mostrarPainel()
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
		
		
		public void atualizarPainel()
		{
			SwingUtilities.updateComponentTreeUI(this);	
		}	
	}
