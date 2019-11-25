
public class Media {

	/**
	 * Esse método inicia a execução do meu aplicativo 
	 * @param args
	 * @author Thiago Moreira
	 */
	public static void main(String[] args) {
		/*Variáveis criadas para auxiliar na obtenção da média*/
		int soma;
		double media;
		media =0;
		soma=0;
		
		for(int x = 1;x <= 20;x++){
			soma += x;
		}
		media = soma / 20;
		System.out.println("A média é: "+media);
	}

}
