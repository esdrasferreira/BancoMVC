package banco.model.entity;

public class Poupanca {

	
	private int id;
	private Double saldo;
	
	
	public Poupanca(int id, Double saldo) {
		this.id = id;
		this.saldo = saldo;
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
	
	
}
