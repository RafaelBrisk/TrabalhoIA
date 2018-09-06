package labirinto;

import java.util.ArrayList;
import java.util.List;

public class Largura {
	
	public static void main(String[] args) {
		Largura largura = new Largura();
		largura.buscar(LabirintoFactory.get16x16(), 16, 16);
		System.out.println("Nodes: " + largura.getQtdNos());
		System.out.println("Tempo: " + largura.getNanoTempo() + " ns.");
	}
	
	private boolean[][] quadrados;
	
	private boolean[][] lugaresVisitados;
	
	private int numeroLinhas;
	private int numeroColunas;
	private Long nanoTempo = 0L;
	private Long qtdNos = 0L;
	
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
		
		List<LabirintoCaminho> espalhar = espalhar(caminhos);
		
		LabirintoCaminho solucao = recursivo(espalhar);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Linha " + solucao.getRow() + " Coluna " + solucao.getColumn() + "\n");
		
		LabirintoCaminho caminhando = solucao;
		while ((caminhando = caminhando.getAnterior()) != null) {
			builder.append("Linha " + caminhando.getRow() + " Coluna " + caminhando.getColumn() + "\n");
		}
		
		System.out.println(builder.toString());
		nanoTempo = System.nanoTime() - nanoStartT;
	}
	
	private LabirintoCaminho recursivo(List<LabirintoCaminho> caminhos) {
		if (caminhos.isEmpty()) {
			throw new RuntimeException("Não há solução!");
		}

		for (LabirintoCaminho labirintoCaminho : caminhos) {
			if (labirintoCaminho.getRow() == (numeroLinhas - 1) && labirintoCaminho.getColumn() == (numeroColunas - 1)) {
				return labirintoCaminho;
			}
		}
		
		return recursivo(espalhar(caminhos));
	}

	private List<LabirintoCaminho> espalhar(List<LabirintoCaminho> caminhos) {
		List<LabirintoCaminho> retorno = new ArrayList<>();
		
		for (LabirintoCaminho labirintoCaminho : caminhos) {
			
			int row = labirintoCaminho.getRow();
			int column = labirintoCaminho.getColumn();
			
			// Esquerda
			int colunaEsquerda = column - 1;
			if (colunaEsquerda > -1) {
				if (!quadrados[row][colunaEsquerda]) {
					if (!lugaresVisitados[row][colunaEsquerda]) {
						LabirintoCaminho labirintoCaminhoEsquerda = new LabirintoCaminho();
						qtdNos++;
						labirintoCaminhoEsquerda.setRow(row);
						labirintoCaminhoEsquerda.setColumn(colunaEsquerda);
						labirintoCaminhoEsquerda.setAnterior(labirintoCaminho);
						retorno.add(labirintoCaminhoEsquerda);
						lugaresVisitados[row][colunaEsquerda] = true;
					}
				}
			}
			
			// Cima
			int rowCima = row - 1;
			if (rowCima > -1) {
				if (!quadrados[rowCima][column]) {
					if (!lugaresVisitados[rowCima][column]) {
						LabirintoCaminho labirintoCaminhoCima = new LabirintoCaminho();
						qtdNos++;
						labirintoCaminhoCima.setRow(rowCima);
						labirintoCaminhoCima.setColumn(column);
						labirintoCaminhoCima.setAnterior(labirintoCaminho);
						retorno.add(labirintoCaminhoCima);
						lugaresVisitados[rowCima][column] = true;
					}
				}
			}
			
			// Direita
			int colunaDireita = column + 1;
			if (colunaDireita < numeroColunas) {
				if (!quadrados[row][colunaDireita]) {
					if (!lugaresVisitados[row][colunaDireita]) {
						LabirintoCaminho labirintoCaminhoDireita = new LabirintoCaminho();
						qtdNos++;
						labirintoCaminhoDireita.setRow(row);
						labirintoCaminhoDireita.setColumn(colunaDireita);
						labirintoCaminhoDireita.setAnterior(labirintoCaminho);
						retorno.add(labirintoCaminhoDireita);
						lugaresVisitados[row][colunaDireita] = true;
					}
				}
			}
			
			// Baixo
			int rowBaixo = row + 1;
			if (rowBaixo < numeroLinhas) {
				if (!quadrados[rowBaixo][column]) {
					if (!lugaresVisitados[rowBaixo][column]) {
						LabirintoCaminho labirintoCaminhoBaixo = new LabirintoCaminho();
						qtdNos++;
						labirintoCaminhoBaixo.setRow(rowBaixo);
						labirintoCaminhoBaixo.setColumn(column);
						labirintoCaminhoBaixo.setAnterior(labirintoCaminho);
						retorno.add(labirintoCaminhoBaixo);
						lugaresVisitados[rowBaixo][column] = true;
					}
				}
			}
			
		}
		
		return retorno;
	}

	public Long getNanoTempo() {
		return nanoTempo;
	}

	public Long getQtdNos() {
		return qtdNos;
	}

}
