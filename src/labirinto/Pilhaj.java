package labirinto;

import java.util.LinkedList;
import java.util.List;

public class Pilhaj {
	
	private List<LabirintoCaminho> lCaminho = new LinkedList<LabirintoCaminho>();

	public void insere(LabirintoCaminho labirintoCaminho) {
		this.lCaminho.add(labirintoCaminho);
	}

	public LabirintoCaminho remove() {
	  	return this.lCaminho.remove(this.lCaminho.size() - 1);
  	}
}
