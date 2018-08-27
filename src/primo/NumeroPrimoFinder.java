package primo;

public class NumeroPrimoFinder {
	
	public static void main(String[] args) {
		new NumeroPrimoFinder();
	}
	
	public NumeroPrimoFinder() {
		
		Cronometro cronometro = new Cronometro();
		cronometro.iniciar();
		
		double numeroAtual = 33d;
		
		short somaQuatro = 3;
		
		short totalSomadoMultiplo3 = 0;
		
		double ultimoPrimo = 0;
		
		while (true) {
			if (somaQuatro == 3) {
				somaQuatro = 0;
				numeroAtual += 4;
				totalSomadoMultiplo3 += 4;
				
				if (totalSomadoMultiplo3 % 3 == 0) {
					totalSomadoMultiplo3 = 2;
					somaQuatro += 1;
					numeroAtual += 2;
				}
			} else {
				somaQuatro += 1;
				numeroAtual += 2;
				totalSomadoMultiplo3 += 2;
				
				if (totalSomadoMultiplo3 % 3 == 0) {
					
					if (somaQuatro == 3) {
						somaQuatro = 0;
						numeroAtual += 4;
						totalSomadoMultiplo3 = 4;
					} else {
						somaQuatro += 1;
						numeroAtual += 2;
						totalSomadoMultiplo3 = 2;
					}
				}
			}
			
			if (numeroAtual > 999999d) {
				System.out.println(ultimoPrimo);
				System.out.println("Tempo: " + cronometro.getValor());
				break;
			}
			
			boolean primo = true;
			
			double divisor = ((numeroAtual - 1) / 2);
			
			if (divisor % 2 == 0) {
				divisor--;
			}
			
			short subtraiQuatro = -1;
			
			while (divisor > 5) {
				if (numeroAtual % divisor == 0) {
					primo = false;
					break;
				} else if (subtraiQuatro == 3) {
					divisor -= 4;
					subtraiQuatro = 0;
				} else {
					divisor -= 2;
					
					if (subtraiQuatro == -1) {
						if (divisor % 5 == 0) {
							subtraiQuatro = 0;
							divisor -= 2;
						}
					} else {
						subtraiQuatro++;
					}
				}
				
			}
			
			if (primo) {
//				System.out.println(numeroAtual);
				ultimoPrimo = numeroAtual;
			}
		}
	}

}
