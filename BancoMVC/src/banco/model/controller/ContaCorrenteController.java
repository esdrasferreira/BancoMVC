package banco.model.controller;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ClienteDAO;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.Cliente;
import banco.model.entity.ContaCorrente;
import banco.model.service.calculos.Calculo;
import banco.model.service.validation.ContaCorrenteValidation;

public class ContaCorrenteController {

	private ContaCorrenteDAO dao;
	private Calculo calculo;

	ContaCorrenteValidation valida;

	public ContaCorrenteController() throws ConexaoException {
		this.dao = new ContaCorrenteDAO();
	}

	public List<ContaCorrente> getContas() throws ConexaoException {

		dao = new ContaCorrenteDAO();
		List<ContaCorrente> contas = dao.getAllCCfromBD();

		System.out.println("Lista de todos as contas:");

		for (ContaCorrente clien : contas) {
			System.out.printf("ID conta: %02d\t|Saldo: R$ %.2f\t | Tipo conta: %s%n", clien.getId(), clien.getSaldo(),
					clien.getTipo());
		}
		System.out.println();
		return contas;

	}/* getContas */
	
	public List<ContaCorrente> getOneAccount(int idConta)throws ConexaoException {
		dao = new ContaCorrenteDAO();
		List<ContaCorrente> contas = dao.getOneCC(idConta);
		
		System.out.println("Conta adquirida:");
		for (ContaCorrente clien : contas) {
			System.out.printf("ID conta: %02d\t|Saldo: R$ %.2f\t | Tipo conta: %s%n", clien.getId(), clien.getSaldo(),
					clien.getTipo());
		}
		System.out.println();
		return contas;
		
	}
	
	public void depositar (int idConta, double valor) throws ConexaoException {
		
		if (valor < 0) {
			System.out.println("Valor de deposito inválido.");
		} else {
			
			
			calculo = new Calculo();
			calculo.depositar(idConta, valor);
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}/* ContaCorrenteController */
