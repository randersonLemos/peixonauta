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
	private static int valoresLimiteElementosSemPiloto[] = new int[]{ 810, 165, 15, 10 }; // livre, muralha, fogo, pocao
	private static Random random = new Random();
	private Boolean comecar = false;
	private Boolean fimDeJogo = false;
	
	ICircuitoControle icirc = null;
	IPilotoControle ipilo = null;
	IPainelControle ipain = null;
	IComandoControle icoma = null;
	
	int i = 0;
	
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
	
	
	public void bloquearExecucao()
	{
		while(true)
		{
			if(comecar)
			{
				break;
			}
			try 
			{
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}				
	}
	
	
	public void tentarDecrementarPoderzin()
	{
		int poderzin = ipilo.getPoderzin();
		
		if(poderzin > 0) // Atualizando a duracao da pocao
		{
			poderzin--;
			ipilo.setPoderzin(poderzin);
		}
		if(poderzin == 0)
		{
			poderzin--;
			ipilo.setPoderzin(poderzin);
			ipilo.setImagemIcon1();
		}
	}
	
	
	public void gerenciarInteracaoPilotoMura()
	{
		int lin = ipilo.getLin();
		int col = ipilo.getCol();	
		Elemento elem = icirc.getElemento(lin, col);
		
		if(elem.getSimbolo().equals("M"))
		{
			if(lin+1 >= icirc.getMaxLin())
			{
				Terminar("Muro te cercou");
			}
			ipilo.moverParaBaixo();
		}
	}
	
	
	public void gerenciarInteracaoPilotoFogo()
	{
		int lin = ipilo.getLin();
		int col = ipilo.getCol();
		Elemento elem = icirc.getElemento(lin, col);
		
		if(elem.getSimbolo().equals("F") && ipilo.getPoderzin() <= 0)
		{
			Terminar("Fogo");
		}
	}
	
	
	public void gerenciarInteracaoPilotoPorcao()
	{
		int lin = ipilo.getLin();
		int col = ipilo.getCol();	
		Elemento elem = icirc.getElemento(lin, col);
		
		if(elem.getSimbolo().equals("C"))
		{
			ipilo.setPoderzin(60);  // Tempo de duracao da pocao
			ipilo.setImagemIcon2();
		}		
	}
	
	
	public void comecarJogo()
	{
		ipain.addPlayActionListener(this);
		ipain.addPlayKeyListener(this);
		//ipain.addResetActionListener(this);
		ipain.mostrarPainel();
		ipain.atualizarImagemCircuitoPainel();
		ipain.atualizarImagemPilotoPainel();
		ipain.atualizarPainel();
		
		ipain.atualizarStatus("Esperando início do jogo!!!");

		int maxI = 500;
		
		for(this.i=0; this.i<maxI; this.i++)
		{	
			bloquearExecucao();
			tentarDecrementarPoderzin();
			avancarElementosUmaLinhaNoCircuito();

			this.gerenciarInteracaoPilotoMura();
			this.gerenciarInteracaoPilotoFogo();
			this.gerenciarInteracaoPilotoPorcao();			
			
			ipain.atualizarImagemCircuitoPainel();
			ipain.atualizarImagemPilotoPainel();
			ipain.atualizarScore(i*10 + 10);
			ipain.atualizarPainel();
			
			try 
			{	
				float a = (1 - 150)/(float)maxI;
				float b = 150;
				Thread.sleep((int)(a*i + b));
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			if(this.fimDeJogo)
			{
				bloquearExecucao();
			}
		}
		
		ipain.atualizarStatus("Parabéns, você venceu!!!");
	}


	public void keyTyped(KeyEvent e) {
		String key = "" + e.getKeyChar() + "";

		if(comecar)
		{
			if(key.toLowerCase().equals("w"))
			{
				tentarMoverParaCima();
			}
			
			if(key.toLowerCase().equals("s"))
			{
				tentarMoverParaBaixo();
			}
			
			if(key.toLowerCase().equals("a"))
			{
				tentarMoverParaEsquerda();
			}

			if(key.toLowerCase().equals("d"))
			{
				tentarMoverParaDireita();
			}

		}
		
		if(key.toLowerCase().equals("r"))
		{
			this.reiniciar();
			this.i = 0;
			ipilo.setImagemIcon1();
			ipain.atualizarStatus("Esperando início do jogo!!!");
		}
		
		this.gerenciarInteracaoPilotoFogo();
		this.gerenciarInteracaoPilotoPorcao();	
		this.gerenciarInteracaoPilotoMura();
			
		ipain.atualizarImagemCircuitoPainel();
		ipain.atualizarImagemPilotoPainel();
		ipain.atualizarPainel();
	}
	
	
	public void tentarMoverParaCima()
	{
		int lin = ipilo.getLin();
		int col = ipilo.getCol();
		Elemento elem = icirc.getElemento(lin, col);
		if(elem.getSimbolo().equals("M"))		
			ipilo.moverParaBaixo();
		
		lin = ipilo.getLin();
		col = ipilo.getCol();
		lin -= 1;
		elem = icirc.getElemento(lin, col);
		if(!elem.getSimbolo().equals("M"))
			ipilo.moverParaCima();
	}
	
	
	public void tentarMoverParaBaixo()
	{
		int lin = ipilo.getLin();
		int col = ipilo.getCol();
		Elemento elem = icirc.getElemento(lin, col);
		if(elem.getSimbolo().equals("M"))		
			ipilo.moverParaCima();
		
		lin = ipilo.getLin();
		col = ipilo.getCol();
		lin += 1;
		elem = icirc.getElemento(lin, col);
		if(!elem.getSimbolo().equals("M"))
			ipilo.moverParaBaixo();
	}
	
	
	public void tentarMoverParaEsquerda()
	{
		int lin = ipilo.getLin();
		int col = ipilo.getCol();
		col -= 1;
		Elemento elem = icirc.getElemento(lin, col);
		if(!elem.getSimbolo().equals("M"))
			ipilo.moverParaEsquerda();	
	}
	
	
	public void tentarMoverParaDireita()
	{		
		int lin = ipilo.getLin();
		int col = ipilo.getCol();
		col += 1;
		Elemento elem = icirc.getElemento(lin, col);
		if(!elem.getSimbolo().equals("M"))
			ipilo.moverParaDireita();		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		try 
		{
			Thread.sleep(10);
		} catch (InterruptedException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub			
	}
	
	
	public void actionPerformed(ActionEvent evento)
	{	
		ipain.atualizarStatus("Boa Sorte!!!");
		comecar = true;	
	}
	
	
	public void Terminar(String motivo) {
		//Criar janela dizendo "GAME OVER"
		if(motivo.equals("Muro te cercou"))
		{
			ipain.atualizarStatus("Game over, você foi consumido pelo fogo!!!");
		}
		else if(motivo.equals("Fogo"))
		{
			ipain.atualizarStatus("Game over, você explodiu!!!");			
		}
		ipilo.setImagemIcon3();
		comecar = false;
		this.fimDeJogo = true;
	}
	
	
	public void reiniciar()
	{			
		for(int lin=0; lin<icirc.getMaxLin(); lin++)
		{
			for(int col=0; col<icirc.getMaxCol(); col++)
			{
				if(lin < icirc.getMaxLin() - 2)
				{
					Elemento elemento = geradorAleatorioDeElementosSemPiloto(lin, col);
					icirc.setElemento(elemento);					
				}
				else
				{
					icirc.setElemento(new Livre(lin, col));
				}
			}
		}
		ipilo.setPosicao(icirc.getMaxLin()-1, icirc.getMaxCol()/2);		
	}
}