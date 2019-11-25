package java.magazine.shards.exemplo.modelo;

public class Contato {
  private Integer contatoId;
  private Integer inquilinoId;
  private String nome;
  private String telefone;
  private String endereco;

  // Getters and Setters

	public Integer getContatoId() {
		return contatoId;
	}
	public void setContatoId(Integer contatoId) {
		this.contatoId = contatoId;
	}
	public Integer getInquilinoId() {
		return inquilinoId;
	}
	public void setInquilinoId(Integer inquilinoId) {
		this.inquilinoId = inquilinoId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return (new StringBuffer ("Id: "+contatoId)
		.append(" InquilinoId: "+inquilinoId)
		.append(" Nome: "+nome)
		.append(" Telefone: "+telefone)
		.append(" Endereço "+endereco)).toString();
	}
}
