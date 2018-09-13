package primo;

public class NumeroPrimoFinder {
	
	static boolean EhPrimo(int numero) {
		if (numero == 1) {
			return true;
		}
	
		boolean retorno = false;
		
		int metade = numero / 2;
		
		if (metade % 2 == 0) {
			metade--;
		}
		
		for (int i = 3; i < metade; i += 2) {
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
		long numeroStop = 9999999;
		for (int numero = 33; numero < numeroStop; numero += 2) {
			if (EhPrimo(numero)) {
				primo = numero;
			}
		}
		System.out.println("Maior primo: " + primo);
		System.out.println("Tempo: " + cronometro.getValor()); 
	}

}
