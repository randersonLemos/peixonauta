package mc322.lab05b;

public class AppDama {

	static void testaPecas()
	{
		System.out.println("Testando pe�as.\n\n");
		
		Peca peca = new Peca("a", 2, 2);	
		
		System.out.println("Tipo: " + peca.getTipo() + ", cor: " + peca.getCor());
		
		peca = new Peao("b", 2, 2);
		
		System.out.println("Tipo: " + peca.getTipo() + ", cor: " + peca.getCor());
		
		peca = new Dama("b", 2, 2);
		
		System.out.println("Tipo: " + peca.getTipo() + ", cor: " + peca.getCor());	
		
		System.out.println("\n\n---");
	}
	
	static void testaTabuleiro()
	{
		System.out.println("Testando Tabuleiro.\n\n");
		
		Tabuleiro tab = new Tabuleiro();
		
		tab.imprimirTabuleiro();
		
		System.out.println("\n\n---");
	}
	
	static void testaJogo()
	{
		System.out.println("Testando Jogo.\n\n");
		
		Tabuleiro tab = new Tabuleiro();
		
		CSVHandling csv = new CSVHandling(); 
		
		csv.setDataSource("./comandos.csv");
		
		//csv.setDataSource("C:\\Users\\Pablo\\eclipse-workspace\\Jogos_de_Damas\\src\\mc322\\lab05\\comandos.csv");
		
		String[] comandos = csv.requestCommands();
		
		for(int i=0; i<comandos.length; i++)
		{
			tab.imprimirTabuleiro();
			tab.solicitaMovimento(comandos[i]);
		}
		
		String[] state = tab.exportarArquivo();
		
		//usar o exportState(state)
		
		System.out.println("\n\n---");
	}
	
	public static String[] executaJogo(String caminho_entrada_csv, String caminho_sainda_csv)
	{
		Tabuleiro tab = new Tabuleiro();
		
		CSVHandling csv = new CSVHandling(); 
		
		csv.setDataSource(caminho_entrada_csv);
		
		String[] comandos = csv.requestCommands();
		String estados[] = new String[comandos.length+1];
		estados[0] = tab.estadoTabuleiro();
		
		for(int i=0; i<comandos.length; i++)
		{
			tab.imprimirTabuleiro();
			tab.solicitaMovimento(comandos[i]);
			estados[i+1] = tab.estadoTabuleiro();

		}
		
		String[] state = tab.exportarArquivo();
		csv.setDataExport(caminho_sainda_csv);
		csv.exportState(state);

		return estados;
	}

	public static void main(String[] args)
	{		
		if(args.length == 2)
		{
			String[] estados = executaJogo(args[0], args[1]);
		}
		else
		{
			System.out.println("Arquivos de entrada e saída não especificados...");
		}
	}
}