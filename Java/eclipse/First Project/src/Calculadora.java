public class Calculadora {
	public static void main( String [ ] args) {
		int sum, x;
		x = 1;
		sum = 0;
		while ( x <= 10){
			sum += x;
			++x;
		}
		System.out.println("A soma �:"+ sum +" O nome dos alunos s�o: " + args[0]+", "+args[1]+" "+args[2]);
	}
}