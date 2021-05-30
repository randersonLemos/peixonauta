package mc322.lab07.control.controle;

import java.util.Random;

import mc322.lab07.model.circuito.ICircuitoControle;
import mc322.lab07.model.elemento.Bebida;
import mc322.lab07.model.elemento.Cafe;
import mc322.lab07.model.elemento.Elemento;
import mc322.lab07.model.elemento.Fogo;
import mc322.lab07.model.elemento.Livre;
import mc322.lab07.model.elemento.Muralha;

public class Controle implements IControle{	
	private static int limiteSuperiorNumeroSorteado = 15;
	private static int valoresLimiteElementosSemPiloto[] = new int[]{ 10, 2, 1, 1, 1 }; // livre, muralha, fogo, cafe, bebida
	private static Random random = new Random();

	ICircuitoControle icirc = null;
	
	public void conectar(ICircuitoControle icircCont)
	{
		this.icirc = icircCont;
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
					if(i == 4)
					{
						return new Bebida(lin, col);	
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
}