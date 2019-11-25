
public class TesteAluno {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		aluno1.setCPF("032234567-09");
		aluno1.setDataNascimento("12/07/1983");
		aluno1.setIdade(26);
		aluno1.setNome("Paulo Jalasca");
		aluno1.setMatricula("123321");


		aluno1.solicitarHistoricoEscolar();
		System.out.println(aluno1.getNome());
	}

}
