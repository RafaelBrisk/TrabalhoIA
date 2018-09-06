package arvore;

import java.util.ArrayList;
import java.util.List;

public class Heuristica {
	
	private List<ArvoreCaminho> emMemoria = new ArrayList<>();
	
	private String nomeDestino;
	
	public void buscar(Arvore arvore, String nomeDestino) {
		this.nomeDestino = nomeDestino;
		
		procurarMelhorFilho(arvore);
		
	}

	private void procurarMelhorFilho(Arvore arvore) {
		if (arvore.getNome().equals(nomeDestino)) {
			System.out.println(arvore.getNome());
			return;
		}
		List<ArvoreCaminho> filhos = arvore.getFilhos();
		
		remover(arvore);
		
		for (ArvoreCaminho arvoreCaminho : filhos) {
			emMemoria.add(arvoreCaminho);
		}
		
		Long menor = -1L;
		ArvoreCaminho arvoreCaminhoMenor = null;
		for (ArvoreCaminho arvoreCaminho : filhos) {
			if (arvoreCaminho.getDistancia() < menor || menor == -1) {
				menor = arvoreCaminho.getDistancia();
				arvoreCaminhoMenor = arvoreCaminho;
			}
		}
		
		procurarMelhorFilho(arvoreCaminhoMenor.getArvore());
	}

	private void remover(Arvore arvore) {
		int index = -1;
		for (int i = 0; i < emMemoria.size(); i++) {
			ArvoreCaminho arvoreCaminho = emMemoria.get(i);
			
			if (arvoreCaminho.getArvore().equals(arvore)) {
				index = i;
				break;
			}
		}
		
		if (index > -1) {
			emMemoria.remove(index);
		}
	}

}
