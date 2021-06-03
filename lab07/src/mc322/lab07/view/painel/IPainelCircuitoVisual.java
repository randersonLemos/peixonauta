package mc322.lab07.view.painel;

import javax.swing.ImageIcon;
import mc322.lab07.model.elemento.Piloto;

public interface IPainelCircuitoVisual {
	public void construirMatrizJLabel(int maxLin, int maxCol);
	public void mostrarJanela();
	public void atualizarImagem(Piloto piloto, ImageIcon imagem, int lin, int col);
	public void atualizar();
}
