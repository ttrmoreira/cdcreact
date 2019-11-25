
public class SomaInteiros {
	public static void main (String [] args){
		int [] arrayInteiros = {10,20,30,40,70};
		int soma = 0;
		for(int i = 0;i < arrayInteiros.length;i++){
			soma += arrayInteiros[i];
		}
		System.out.println("A soma é: "+soma);
	}
}
