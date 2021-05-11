package mc322.lab06;

public class Caverna {
	Sala matrix[][] = new Sala[4][4];
	
	Caverna()
	{
		for(int l=0; l<4; l++)
		{
			for(int c=0; c<4; c++)
			{
				matrix[l][c] = new Sala(l, c);
			}
		}
	}
	
	void adicionaComponente(Componente componente)
	{
		if(componente != null)
		{
			int lin = componente.lin;
			int col = componente.col;
			
			Sala sala = matrix[lin][col];
			sala.adicionaComponente(componente);
			
			if(componente.getSim().equals("P"))
				sala.foiVisitada();
			sala.foiVisitada();
		}
	}
	
	
	void tentaAdicionarComponenteSecundario(Componente componente)
	{
		if(componente != null)
		{
			int lin = componente.lin;
			int col = componente.col;			
			
			if(lin >= 0 && lin < 4 && col >= 0 & col < 4)
			{
				Sala sala = matrix[lin][col];
				sala.adicionaComponente(componente);
			}
		}
	}
	
	
	void atualizarCaverna(int lin_ant, int col_ant, int lin_nov, int col_nov) {
		Sala sala = matrix[lin_ant][col_ant];
		Componente heroi = sala.heroi;
		sala.heroi = null;
		sala  = matrix[lin_nov][col_nov];
		sala.heroi = heroi;
		sala.foiVisitada();
		//Atualizar a posi��o do heroi
		//Revelar a sala
		
		//metodo foiVisitada ta no GameControl, mas acho q pode ser passada pra c�
	}
		
	void verEstadosCaverna()
	{		
		for(int l=0; l<5; l++)
		{
			for(int c=-1; c<4; c++)
			{
				if(c == -1 && l < 4)
					System.out.print((l+1) + " ");
				if(l == 4 && c > -1)
					System.out.print((c+1) + " ");
				if(l == 4 && c == -1)
					System.out.print(" " + " ");
				if(l >= 0 && l < 4 && c >= 0 & c < 4)
					System.out.print(matrix[l][c].getComSim() + " ");
			}
			System.out.print("\n");
		}
	}
	
	Sala getSala(int lin, int col) {
		return matrix[lin][col];
	}
}