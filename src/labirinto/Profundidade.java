package labirinto;

import java.util.Stack;

public class Profundidade {
	
	public static void main(String[] args) {
		Profundidade profundidade = new Profundidade();
		profundidade.buscar(LabirintoFactory.get32x32(), 32, 32);
		
		System.out.println(profundidade.getTempo());
		System.out.println(profundidade.getQtdNos());
	}
	
	private Stack<LabirintoCaminho> caminho = new Stack<>();
	
	private LabirintoCaminho ultimo = new LabirintoCaminho();
	
	private int numeroLinhas;
	private int numeroColunas;
	private boolean[][] lugaresVisitados;
	private boolean[][] quadrados;
	private Long tempo = 0L;
	private Long qtdNos = 0L;
	
	public void buscar(boolean[][] quadrados, int numeroLinhas, int numeroColunas) {
		
		long nanoStartT = System.nanoTime();
		
		this.quadrados = quadrados;
		this.numeroLinhas = numeroLinhas;
		this.numeroColunas = numeroColunas;
		
		lugaresVisitados = new boolean[numeroLinhas][numeroColunas];
		lugaresVisitados[0][0] = true;
		
		LabirintoCaminho labirintoCaminho = new LabirintoCaminho();
		
		labirintoCaminho.setColumn(0);
		labirintoCaminho.setRow(0);
		ultimo = labirintoCaminho;
		caminho.push(labirintoCaminho);
		
		boolean terminou = executar();
		
		if (!terminou) {
			throw new RuntimeException("Não há solução.");
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Linha " + ultimo.getRow() + " Coluna " + ultimo.getColumn() + "\n");
		
		LabirintoCaminho caminhando = ultimo;
		while ((caminhando = caminhando.getAnterior()) != null) {
			builder.append("Linha " + caminhando.getRow() + " Coluna " + caminhando.getColumn() + "\n");
		}
		
		System.out.println(builder.toString());
		
		tempo = System.nanoTime() - nanoStartT;
	}
	
	private boolean executar() {
		if (ultimo.getRow() == (numeroLinhas - 1) && ultimo.getColumn() == (numeroColunas - 1)) {
			return true;
		}
		
		while (!andar()) {
			voltar();
		}
		
		return executar();
	}

	private boolean andar() {
		int linha = ultimo.getRow();
		int coluna = ultimo.getColumn();
		
		int colunaEsquerda = coluna - 1;
		int colunaDireita = coluna + 1;
		int linhaCima = linha - 1;
		int linhaBaixo = linha + 1;
		
		if (colunaEsquerda >= 0) {
			if (!quadrados[linha][colunaEsquerda] && !lugaresVisitados[linha][colunaEsquerda]) {
				LabirintoCaminho labirintoCaminho = new LabirintoCaminho();
				qtdNos++;
				labirintoCaminho.setRow(linha);
				labirintoCaminho.setColumn(colunaEsquerda);
				caminho.push(labirintoCaminho);
				labirintoCaminho.setAnterior(ultimo);
				ultimo = labirintoCaminho;
				lugaresVisitados[linha][colunaEsquerda] = true;
				return true;
			}
		}
		
		if (linhaCima >= 0) {
			if (!quadrados[linhaCima][coluna] && !lugaresVisitados[linhaCima][coluna]) {
				LabirintoCaminho labirintoCaminho = new LabirintoCaminho();
				qtdNos++;
				labirintoCaminho.setRow(linhaCima);
				labirintoCaminho.setColumn(coluna);
				caminho.push(labirintoCaminho);
				labirintoCaminho.setAnterior(ultimo);
				ultimo = labirintoCaminho;
				lugaresVisitados[linhaCima][coluna] = true;
				return true;
			}
		}
		
		if (colunaDireita < numeroColunas) {
			if (!quadrados[linha][colunaDireita] && !lugaresVisitados[linha][colunaDireita]) {
				LabirintoCaminho labirintoCaminho = new LabirintoCaminho();
				qtdNos++;
				labirintoCaminho.setRow(linha);
				labirintoCaminho.setColumn(colunaDireita);
				caminho.push(labirintoCaminho);
				labirintoCaminho.setAnterior(ultimo);
				ultimo = labirintoCaminho;
				lugaresVisitados[linha][colunaDireita] = true;
				return true;
			}
		}
		
		if (linhaBaixo < numeroLinhas) {
			if (!quadrados[linhaBaixo][coluna] && !lugaresVisitados[linhaBaixo][coluna]) {
				LabirintoCaminho labirintoCaminho = new LabirintoCaminho();
				qtdNos++;
				labirintoCaminho.setRow(linhaBaixo);
				labirintoCaminho.setColumn(coluna);
				caminho.push(labirintoCaminho);
				labirintoCaminho.setAnterior(ultimo);
				ultimo = labirintoCaminho;
				lugaresVisitados[linhaBaixo][coluna] = true;
				return true;
			}
		}
		
		return false;
	}
	
	private void voltar() {
		caminho.pop();
		ultimo = caminho.get(caminho.size() - 1);
	}
	
	public Long getTempo() {
		return tempo;
	}
	
	public Long getQtdNos() {
		return qtdNos;
	}

}
