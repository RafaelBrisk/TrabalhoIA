package arvore;

import java.util.ArrayList;
import java.util.List;

public class ArvoreFactory {
	
	public static Arvore getArvore() {
		Arvore arvore1 = new Arvore();
		Arvore arvore2 = new Arvore();
		Arvore arvore3 = new Arvore();
		
		List<ArvoreCaminho> filhos1 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f1 = new ArvoreCaminho();
		arvoreCaminho1f1.setArvore(arvore2);
		arvoreCaminho1f1.setDistancia(1l);
		filhos1.add(arvoreCaminho1f1);
		ArvoreCaminho arvoreCaminho2f1 = new ArvoreCaminho();
		arvoreCaminho2f1.setArvore(arvore3);
		arvoreCaminho2f1.setDistancia(2l);
		filhos1.add(arvoreCaminho2f1);
		arvore1.setFilhos(filhos1);
		
		
		
		return arvore1;
	}

}
