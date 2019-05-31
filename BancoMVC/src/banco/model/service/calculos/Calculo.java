package banco.model.service.calculos;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.ContaCorrente;



public class Calculo {
	private ContaCorrenteDAO dao;
	
	public void depositar(int idConta, double valor) throws ConexaoException {
		dao = new ContaCorrenteDAO();
		List<ContaCorrente> contas = dao.getOneCC(idConta);
		
		
		double saldo = valor + contas.get(0).getSaldo();
		contas.get(0).setSaldo(saldo);
		
		
		
		dao.updateSaldo(contas.get(0));
		
		
	}/*depositar*/
	
	public void sacar (int idConta, double valor)throws ConexaoException {
		dao = new ContaCorrenteDAO();
		List<ContaCorrente> contas = dao.getOneCC(idConta);
		
		if (valor > contas.get(0).getSaldo()) {
			System.out.println("Valor do saque maior que o valor disponivel, saldo: R$ "+contas.get(0).getSaldo());
		} else {
			double saldo = contas.get(0).getSaldo()-valor;
			contas.get(0).setSaldo(saldo);
			
			dao.updateSaldo(contas.get(0));
			System.out.println("Saque realizado com sucesso, saldo disponível: R$ "+contas.get(0).getSaldo());
		}
		
		
	}/*sacar*/
	
	

	
	
	
	
	
	
}/*Calculo*/
