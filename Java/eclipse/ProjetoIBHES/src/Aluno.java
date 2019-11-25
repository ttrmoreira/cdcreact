
public class Aluno {
	
	private String nome;
	private String CPF;
	private String matricula;
	
	
	public Aluno(String nome, String cpf, String matricula) {
		this.nome = nome;
		this.CPF = cpf;
		this.matricula = matricula;
	}

	public void solicitarMatricula (String CPF){
		System.out.println("O aluno(a) solicitou uma matrícula");
	}
	
	public void solicitarHistoricoEscolar(String matricula){
		System.out.println("O aluno(a) solicitou o histórico escolar");
	}
	
	public void setNome(String nome){
			this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}

	public void setCPF(String CPF){
		this.CPF = CPF;
	}
	
	public String getCPF(){
		return CPF;
	}


	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	
	public String getMatricula(){
		return matricula;
	}

}
