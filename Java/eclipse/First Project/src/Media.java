
public class Media {

	/**
	 * Esse m�todo inicia a execu��o do meu aplicativo 
	 * @param args
	 * @author Thiago Moreira
	 */
	public static void main(String[] args) {
		/*Vari�veis criadas para auxiliar na obten��o da m�dia*/
		int soma;
		double media;
		media =0;
		soma=0;
		
		for(int x = 1;x <= 20;x++){
			soma += x;
		}
		media = soma / 20;
		System.out.println("A m�dia �: "+media);
	}

}
