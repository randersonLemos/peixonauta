package mc322.lab06;

public class Montador {
	Caverna cav = null;
	
	Montador(String caminho_arquivo_csv)
	{
		CSVHandling csv = new CSVHandling(); 	
		
		csv.setDataSource(caminho_arquivo_csv);		
		
		String[][] comandos = csv.requestCommands();
		
		cav = new Caverna();
		
		for(int i=0; i<comandos.length; i++) 
		{
			int lin = Integer.parseInt(comandos[i][0].substring(0, 1)) - 1;
			int col = Integer.parseInt(comandos[i][0].substring(2, 3)) - 1;
			String sim = comandos[i][1];
		
			Componente componente = null;
		
			if(sim.equals("P"))
				componente = new Heroi(lin, col);				
			
			else if(sim.equals("W"))
				componente = new Wumpus(lin, col);

			
			else if(sim.equals("B"))
				componente = new Buraco(lin, col);
			
			else if(sim.equals("O"))
				componente = new Ouro(lin, col);
			
			else if(sim.equals("_"))
				componente = new Componente(lin, col); // Nao faz nada		
			
			else
				System.out.println("Simbolo desconhecido: " + sim);

			cav.adicionaComponente(componente);		
			
			if(componente.getSim().equals("W"))
			{		
				componente = new Fedor(lin + 1 , col);
				cav.tentaAdicionarComponenteSecundario(componente);
				
				componente = new Fedor(lin - 1, col);
				cav.tentaAdicionarComponenteSecundario(componente);

				componente = new Fedor(lin, col + 1);
				cav.tentaAdicionarComponenteSecundario(componente);

				componente = new Fedor(lin, col - 1);		
				cav.tentaAdicionarComponenteSecundario(componente);
			}
			
			if(componente.getSim().equals("B"))
			{		
				componente = new Brisa(lin + 1 , col);
				cav.tentaAdicionarComponenteSecundario(componente);
				
				componente = new Brisa(lin - 1, col);
				cav.tentaAdicionarComponenteSecundario(componente);

				componente = new Brisa(lin, col + 1);
				cav.tentaAdicionarComponenteSecundario(componente);

				componente = new Brisa(lin, col - 1);		
				cav.tentaAdicionarComponenteSecundario(componente);
			}			
		}
	}		
		

	
	public static void main(String args[])
	{
		Montador mon = new Montador("./entrada.csv");
		
		mon.cav.verEstadosCaverna();
	}
}
