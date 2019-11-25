
public class TestaVeiculo {

	public void exibeVolvo(Caminhao [] arrayCaminhoes){
		for(int i = 0; i < arrayCaminhoes.length;i++){
			if(arrayCaminhoes[i].getMarca().equals("Volvo")){
				arrayCaminhoes[i].mostrarDados();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		Caminhao [] arrayCaminhoes = new Caminhao[3];
		
		arrayCaminhoes[0] = new Caminhao("Volvo",300.0f,10,10.0f);
		arrayCaminhoes[1] = new Caminhao("Scania",310.0f,10,14.0f);
		arrayCaminhoes[2] = new Caminhao("Mercedes",290.0f,8,13.0f);

		
		for(int i = 0; i < arrayCaminhoes.length;i++){
			arrayCaminhoes[i].abastecer(20);
		}

		for(int i = 0; i < arrayCaminhoes.length;i++){
			arrayCaminhoes[i].mostrarDados();
		}
		//Exibe somente os caminhões da Volvo
		TestaVeiculo testaVeiculo = new TestaVeiculo();
		testaVeiculo.exibeVolvo(arrayCaminhoes);
	}
}
