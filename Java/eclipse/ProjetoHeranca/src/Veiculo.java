
public class Veiculo {
	private String marca;
	private float qtdCombus;
	private int qtdRodas;
	
	public Veiculo(String marca, float qtdCombus, int qtdRodas) {
		this.marca = marca;
		this.qtdCombus = qtdCombus;
		this.qtdRodas = qtdRodas;
	}
	
	public void abastecer(float qtdCombus){
		this.qtdCombus += qtdCombus; 
		System.out.println("A quantidade atual de combustível é: "+this.qtdCombus);
	}
	
	public void mostrarDados(){
		System.out.println("Marca do veículo: "+this.marca+" \n Quantidade de combustível: "+this.qtdCombus+" \n Quantidade de rodas "+this.qtdRodas);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getQtdCombus() {
		return qtdCombus;
	}

	public void setQtdCombus(float qtdCombus) {
		this.qtdCombus = qtdCombus;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}
	
	
}
