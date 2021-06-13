package mc322.lab07.control.comandos;

import java.awt.event.KeyListener;

public interface IComando extends
  IComandoControle
, KeyListener
{
	public void run();
}

