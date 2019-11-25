import javax.swing.JOptionPane;


public class Aluno {
	private String nome;
	private String CPF;
	private int idade;
	private String dataNascimento;
	private String matricula;
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		if(nome.equals("João")){
			this.nome = nome;
		}
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if(idade >= 25){
			this.idade = idade;
		}else{
			this.idade = 0;
		}
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void solicitarHistoricoEscolar(){
		Integer matricula =  Integer.parseInt(JOptionPane.showInputDialog("Entre com a matrícula"));
		JOptionPane.showMessageDialog(null, "O aluno "+matricula.intValue()+" solicitou o Histórico Escolar");
	}
}
