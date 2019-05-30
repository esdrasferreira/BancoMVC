package banco.model.entity;

public class Cliente {

	private int idCliente;
	private String nome;
	private String cpf;
	private String end;
	
	public Cliente() {}
	
	public Cliente(int idCliente, String nome, String cpf, String end) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.end = end;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	
}
