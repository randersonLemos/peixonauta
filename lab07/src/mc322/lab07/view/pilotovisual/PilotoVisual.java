package mc322.lab07.view.pilotovisual;

import mc322.lab07.model.elemento.IPilotoPilotoVisual;

public class PilotoVisual implements IPilotoVisual{
	IPilotoPilotoVisual ipilo = null;
	
	public void conectar(IPilotoPilotoVisual ipilo)
	{
		this.ipilo = ipilo;
	}
}
