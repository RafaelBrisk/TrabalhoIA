package labirinto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Profundidadej {
	
	public static void main(String[] args) {
		Largura largura = new Largura();
		largura.buscar(LabirintoFactory.get8x8(), 8, 8);
	}
	
	private boolean[][] quadrados;
	
	private boolean[][] lugaresVisitados;
	
	private int numeroLinhas;
	private int numeroColunas;
	private Long nanoTempo;
	private Long qtdNos;
	
	public void buscar(boolean[][] quadrados, int numeroLinhas, int numeroColunas) {
			
		long nanoStartT = System.nanoTime();
		
		this.numeroLinhas = numeroLinhas;
		this.numeroColunas = numeroColunas;
		
		this.quadrados = quadrados;
		
		lugaresVisitados = new boolean[numeroLinhas][numeroColunas];
		lugaresVisitados[0][0] = true;
		
		int inicioR = 0;
		int inicioC = 0;
		
		List<LabirintoCaminho> caminhos = new ArrayList<>();
		
		LabirintoCaminho labirintoCaminho = new LabirintoCaminho();
		qtdNos++;
		labirintoCaminho.setRow(inicioR);
		labirintoCaminho.setColumn(inicioC);
		caminhos.add(labirintoCaminho);
		
//		List<LabirintoCaminho> espalhar = espalhar(caminhos);
//		
////		LabirintoCaminho solucao = recursivo(espalhar);
//		
//		StringBuilder builder = new StringBuilder();
//		
//		builder.append("Linha " + solucao.getRow() + " Coluna " + solucao.getColumn() + "\n");
//		
//		LabirintoCaminho caminhando = solucao;
//		while ((caminhando = caminhando.getAnterior()) != null) {
//			builder.append("Linha " + caminhando.getRow() + " Coluna " + caminhando.getColumn() + "\n");
//		}
		
//		System.out.println(builder.toString());

		nanoTempo = System.nanoTime() - nanoStartT;
	}
	
	private Pilhaj percorrer(List<LabirintoCaminho> caminhos) {
		Pilhaj pilha = new Pilhaj();
		
		for (LabirintoCaminho labirintoCaminho : caminhos) {
			
			int row = labirintoCaminho.getRow();
			int column = labirintoCaminho.getColumn();
			
			
			for (int i = 0; i < numeroLinhas; i++) {
				for (int j = 0; j < numeroColunas; i++) {
					if (column > -1) {
						if (!quadrados[row][column]) {
							if (!lugaresVisitados[row][column]) {
								
							}
						}
					}
					qtdNos++;
					pilha.insere(labirintoCaminho);
					
					lugaresVisitados[row][column] = true;
				}
			}		
		}
		return pilha;
	}
}
	

