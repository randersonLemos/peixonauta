package mc322.lab07.control.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import mc322.lab07.control.comandos.IComandoControle;
import mc322.lab07.model.circuito.ICircuitoControle;
import mc322.lab07.model.elemento.Cafe;
import mc322.lab07.model.elemento.Elemento;
import mc322.lab07.model.elemento.Fogo;
import mc322.lab07.model.elemento.IPilotoControle;
import mc322.lab07.model.elemento.Livre;
import mc322.lab07.model.elemento.Muralha;
import mc322.lab07.view.painel.IPainelControle;

public class Controle implements IControle, ActionListener, KeyListener
{	
	private static int limiteSuperiorNumeroSorteado = 1000;
	private static int valoresLimiteElementosSemPiloto[] = new int[]{ 800, 180, 15, 5 }; // livre, muralha, fogo, pocao
	private static Random random = new Random();
	private Boolean comecar = false;
	
	ICircuitoControle icirc = null;
	IPilotoControle ipilo = null;
	IPainelControle ipain = null;
	IComandoControle icoma = null;

	
	public void conectar(ICircuitoControle icircCont)
	{
		this.icirc = icircCont;
	}
	
	
	public void conectar(IPilotoControle ipiloCont)
	{
		this.ipilo = ipiloCont;
	}
	
	
	public void conectar(IPainelControle ipain)
	{
		this.ipain = ipain;
	}
	
	
	public void conectar(IComandoControle icoma)
	{
		this.icoma = icoma;
	}
	
	
	public Elemento geradorAleatorioDeElementosSemPiloto(int lin, int col)
	{
		int valor = random.nextInt(limiteSuperiorNumeroSorteado);
		
		while(true)
		{
			for(int i=0; i<valoresLimiteElementosSemPiloto.length; i++)
			{
				int valorLimite = valoresLimiteElementosSemPiloto[i];
				if(valor < valorLimite)
				{
					if(i == 0)
					{
						return new Livre(lin, col);
					}
					if(i == 1)
					{
						return new Muralha(lin, col);
					}
					if(i == 2)
					{
						return new Fogo(lin, col);
					}
					if(i == 3)
					{
						return new Cafe(lin, col);
					}
				}
				valor -= valorLimite;
			}
		}		
	}
	
	
	public void avancarElementosUmaLinhaNoCircuito()
	{
		for(int lin=icirc.getMaxLin() - 1; lin > 0; lin--)
		{
			for(int col=0; col<icirc.getMaxCol(); col++)
			{
				Elemento elem = icirc.getElemento(lin - 1, col);
				elem.setLin(lin);
				elem.setCol(col);
				icirc.setElemento(elem);
			}
		}
		
		for(int col=0; col<icirc.getMaxCol(); col++)
		{
			Elemento elem = geradorAleatorioDeElementosSemPiloto(0, col);
			icirc.setElemento(elem);
		}
	}
	
	
	public void comecarJogo()
	{
		ipain.addActionListener(this);
		ipain.addKeyListener(this);
		ipain.mostrar();
		ipain.atualizarImagemCircuitoPainel();
		ipain.atualizarImagemPilotoPainel();
		ipain.atualizarOndaDeFogo();
		ipain.atualizar();
		
		while(true)
		{
			if(comecar)
			{
				break;
			}
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		int poderzin = 0; //duracao da pocao
		ipain.atualizarStatus("Boa Sorte");
		boolean FimDeJogo = false;
		int maxI = 500;
		int lin;
		int col;
		for(int i=0; i<maxI; i++)
		{
			if(poderzin != 0) //Atualizando a duracao da pocao
				poderzin--;
			
			avancarElementosUmaLinhaNoCircuito();
			if(FimDeJogo)
				break;
			
			lin = ipilo.getLin();
			col = ipilo.getCol();
			//System.out.println(lin);
			if(lin < icirc.getMaxLin()) {
				Elemento elem = icirc.getElemento(lin, col);
				if(elem.getSimbolo().equals("M"))
				{
					if(lin+1 >= icirc.getMaxLin())
						FimDeJogo = Terminar("Muro te cercou");
					ipilo.moverParaBaixo();
				}
				
				if(elem.getSimbolo().equals("F") && poderzin == 0)
					FimDeJogo = Terminar("Fogo");
				else if(elem.getSimbolo().equals("C"))
					poderzin = 60;			//tempo de duracao da pocao
					
				
				ipain.atualizarImagemCircuitoPainel();
				ipain.atualizarImagemPilotoPainel();
				ipain.atualizarScore(i*10 + 10);
				ipain.atualizar();
			}
			try 
			{	
				float a = (1 - 100)/(float)maxI;
				float b = 100;

				Thread.sleep((int)(a*i + b));
				//Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}


	public void keyTyped(KeyEvent e) {
		if(comecar)
		{
			String key = "" + e.getKeyChar() + "";
			if(key.toLowerCase().equals("w"))
			{
				int lin = ipilo.getLin();
				int col = ipilo.getCol();
				Elemento elem = icirc.getElemento(lin, col);
				if(elem.getSimbolo().equals("M"))
				{
					ipilo.moverParaBaixo();
				}
				
				if(!elem.getSimbolo().equals("M"))
					ipilo.moverParaCima();
			}
			
			if(key.toLowerCase().equals("s"))
			{
				ipilo.moverParaBaixo();	
			}
			
			if(key.toLowerCase().equals("a"))
			{
				ipilo.moverParaEsquerda();
			}

			if(key.toLowerCase().equals("d"))
			{
				ipilo.moverParaDireita();	
			}
			
			ipain.atualizarImagemCircuitoPainel();
			ipain.atualizarImagemPilotoPainel();
			ipain.atualizar();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub			
	}
	
	
	public void actionPerformed(ActionEvent evento)
	{	
		comecar = true;	
	}
	
	
	public boolean Terminar(String motivo) {
		//Criar janela dizendo "GAME OVER"
		if(motivo.equals("Muro te cercou"))
			ipain.atualizarStatus("Game Over: Consumido");
		else if(motivo.equals("Fogo"))
			ipain.atualizarStatus("Game Over: Explodiu");
		comecar = false;
		return true;
	}
	
	
	
}