package arvore;

import java.util.ArrayList;
import java.util.List;

public class ArvoreFactory {
	
	public static Arvore getArvore() {
		Arvore arvore1 = new Arvore();
		Arvore arvore2 = new Arvore();
		Arvore arvore3 = new Arvore();
		Arvore arvore4 = new Arvore();
		Arvore arvore5 = new Arvore();
		Arvore arvore6 = new Arvore();
		Arvore arvore7 = new Arvore();
		Arvore arvore8 = new Arvore();
		Arvore arvore9 = new Arvore();
		Arvore arvore10 = new Arvore();
		Arvore arvore11 = new Arvore();
		
		//Arvore 1
		List<ArvoreCaminho> filhos1 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f1 = new ArvoreCaminho();
		arvoreCaminho1f1.setArvore(arvore2);
		arvoreCaminho1f1.setDistancia(2l);
		filhos1.add(arvoreCaminho1f1);
		ArvoreCaminho arvoreCaminho2f1 = new ArvoreCaminho();
		arvoreCaminho2f1.setArvore(arvore3);
		arvoreCaminho2f1.setDistancia(1l);
		filhos1.add(arvoreCaminho2f1);
		arvore1.setFilhos(filhos1);
		
		//Arvore 2
		List<ArvoreCaminho> filhos2 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f2 = new ArvoreCaminho(); //arvoreCaminho1 = primeiro filho
		arvoreCaminho1f2.setArvore(arvore4);				  //f2 = filhos2 = arvore 2
		arvoreCaminho1f2.setDistancia(1l);
		filhos2.add(arvoreCaminho2f1);
		arvore2.setFilhos(filhos2);
		
		//Arvore 3
		List<ArvoreCaminho> filhos3 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f3 = new ArvoreCaminho();
		arvoreCaminho1f3.setArvore(arvore5);
		arvoreCaminho1f3.setDistancia(1l);
		filhos1.add(arvoreCaminho1f3);
		ArvoreCaminho arvoreCaminho2f3 = new ArvoreCaminho();
		arvoreCaminho2f3.setArvore(arvore6);
		arvoreCaminho2f3.setDistancia(1l);
		filhos1.add(arvoreCaminho2f3);
		ArvoreCaminho arvoreCaminho3f3 = new ArvoreCaminho();
		arvoreCaminho3f3.setArvore(arvore7);
		arvoreCaminho3f3.setDistancia(2l);
		filhos3.add(arvoreCaminho3f3);
		arvore3.setFilhos(filhos3);
		
		//Arvore 4
		List<ArvoreCaminho> filhos4 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f4 = new ArvoreCaminho();
		arvoreCaminho1f4.setArvore(arvore5);
		arvoreCaminho1f4.setDistancia(2l);
		filhos4.add(arvoreCaminho1f4);
		arvore4.setFilhos(filhos4);
		
		//Arvore 5
		List<ArvoreCaminho> filhos5 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f5 = new ArvoreCaminho();
		arvoreCaminho1f5.setArvore(arvore8);
		arvoreCaminho1f5.setDistancia(2l);
		filhos5.add(arvoreCaminho1f5);
		ArvoreCaminho arvoreCaminho2f5 = new ArvoreCaminho();
		arvoreCaminho2f5.setArvore(arvore9);
		arvoreCaminho2f5.setDistancia(3l);
		filhos5.add(arvoreCaminho2f5);		
		arvore5.setFilhos(filhos5);
		
		//Arvore 6
		List<ArvoreCaminho> filhos6 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f6 = new ArvoreCaminho();
		arvoreCaminho1f6.setArvore(arvore10);
		arvoreCaminho1f6.setDistancia(1L);
		filhos6.add(arvoreCaminho1f6);
		arvore6.setFilhos(filhos6);
		
		//Arvore 10
		List<ArvoreCaminho> filhos10 = new ArrayList<>();
		ArvoreCaminho arvoreCaminho1f10 = new ArvoreCaminho();
		arvoreCaminho1f10.setArvore(arvore11);
		arvoreCaminho1f10.setDistancia(1L);
		filhos10.add(arvoreCaminho1f10);
		arvore10.setFilhos(filhos10);
		
		return arvore1;
	}

}
