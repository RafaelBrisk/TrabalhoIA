package arvore;

import java.util.List;

public class Arvore {
	
	private List<ArvoreCaminho> filhos;
	
	private String nome;

	public List<ArvoreCaminho> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<ArvoreCaminho> filhos) {
		this.filhos = filhos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
