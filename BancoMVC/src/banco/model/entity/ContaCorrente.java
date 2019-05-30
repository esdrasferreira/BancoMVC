package banco.model.entity;

public class ContaCorrente {
	
	private int id;
	private Double saldo;
	private String tipo;
	
	public ContaCorrente() {}
	
	public ContaCorrente(int id, Double saldo, String tipo) {
		
		this.id = id;
		this.saldo = saldo;
		this.tipo = tipo;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
	

}
