
public class Caminhao extends Veiculo {
	private float limite_carga;

	public Caminhao(String marca, float qtdCombus, int qtdRodas,float limite_carga) {
		super(marca, qtdCombus, qtdRodas);
		this.limite_carga = limite_carga;
	}
	
	public void mostrarDados(){
		System.out.println("Marca do veículo: "+this.getMarca()+" \n Quantidade de combustível: "+this.getQtdCombus()+" \n Quantidade de rodas "+this.getQtdRodas()+"\n Limite de carga: "+this.getLimite_carga());
	}

	public float getLimite_carga() {
		return limite_carga;
	}

	public void setLimite_carga(float limite_carga) {
		this.limite_carga = limite_carga;
	}

	
}
