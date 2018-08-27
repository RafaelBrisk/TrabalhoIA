package primo;

public class Cronometro {
	
	private long inicio;
	
	public void iniciar() {
		inicio = System.currentTimeMillis();
	}
	
	public long getValor() {
		return System.currentTimeMillis() - inicio;
	}
	
	public static void main(String[] args) {
		long tempo = 410983;
		
		long segundos = tempo / 1000;
		long miliRestante = tempo % 1000;
		
		System.out.println(segundos + "s " + miliRestante + "ms");
	}

}
