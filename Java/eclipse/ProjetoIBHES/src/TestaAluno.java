
public class TestaAluno {

	public static void main(String[] args) {
		Aluno []colecaoAlunos = new Aluno[3];
		colecaoAlunos[0] = new Aluno("Thamires","123456789-09","24234423");
		colecaoAlunos[1] = new Aluno("Pedro","543210113-09","123456");
		colecaoAlunos[2] = new Aluno("Eduardo","567879723-13","9876543");

		for(int i = 0;i < colecaoAlunos.length;i++){
			System.out.println("A aluno(a)"+ colecaoAlunos[i].getNome()+" possui a matrícula de número "+ colecaoAlunos[i].getMatricula()+" e o CPF "+colecaoAlunos[i].getCPF());
			colecaoAlunos[i].solicitarHistoricoEscolar(colecaoAlunos[i].getMatricula());
			colecaoAlunos[i].solicitarMatricula(colecaoAlunos[i].getCPF());
			System.out.println();
		}
	}

}
