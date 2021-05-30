package mc322.lab07.view.circuitovisual;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CircuitoVisualJanela extends JFrame{
	private static final long serialVersionUID = 9133938671148624950L;
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
				
		setVisible(true);	
	}
	
	public void atualizar(ImageIcon imagem, int lin, int col)
	{

		JLabel jlabel = new JLabel(imagem, JLabel.CENTER);
        c.gridx = col;
        c.gridy = lin;
		contentPane.add(jlabel, c);	
		SwingUtilities.updateComponentTreeUI(this);	
	}
}
