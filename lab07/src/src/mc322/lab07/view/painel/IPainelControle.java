package mc322.lab07.view.painel;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface IPainelControle 
{
	public void atualizarPainel();
	public void mostrarPainel();
	public void atualizarImagemCircuitoPainel();
	public void atualizarImagemPilotoPainel();
	public void addPlayActionListener(ActionListener I);
	public void addPlayKeyListener(KeyListener I);
	//public void addResetActionListener(ActionListener I);
	public void atualizarScore(int valor);
	public void atualizarStatus(String mensagem);
}
