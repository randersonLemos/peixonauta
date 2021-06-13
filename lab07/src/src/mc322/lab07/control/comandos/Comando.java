package mc322.lab07.control.comandos;

import java.awt.event.KeyEvent;

public class Comando implements IComando
{
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.print("Tecla escolhida");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.print("Tecla apertada");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.print("Tecla solta");
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Estou observando");
		}
	}
}
