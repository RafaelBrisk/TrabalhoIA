package primo;

public class PrimoForcaBruta {
	static boolean EhPrimo(int numero) {
		if (numero == 1) {
			return true;
		}
	
		boolean retorno = false;
		for (int i = 2; i < numero; i++) {
			retorno = (numero % i == 0);
			if (retorno) {
				break;
			}
		}
		return !retorno;
	}
	
	
	public static void main(String[] args) {
		Cronometro cronometro = new Cronometro();
		cronometro.iniciar();
		
		long primo = 0;
		long numeroStop = 999999;
		for (int numero = 1; numero < numeroStop; numero++) {
			if (EhPrimo(numero)) {
				primo = numero;
			}
		}
		System.out.println("Maior primo: " + primo);
		System.out.println("Tempo: " + cronometro.getValor()); 
	}
}
