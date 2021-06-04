package mc322.lab07.view.painel;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface IPainelControle 
{
	public void atualizar();
	public void mostrar();
	public void atualizarImagemCircuitoPainel();
	public void atualizarImagemPilotoPainel();
	public void addActionListener(ActionListener I);
	public void addKeyListener(KeyListener I);
	public void atualizarScore(int valor);
}
