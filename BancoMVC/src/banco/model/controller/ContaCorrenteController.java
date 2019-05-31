package banco.model.controller;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.ContaCorrente;
import banco.model.service.calculos.Calculo;
import banco.model.service.validation.ContaCorrenteValidation;

public class ContaCorrenteController {

	
	private ContaCorrenteDAO dao;
	private Calculo calculo;
	private ContaCorrenteValidation valida;

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
		valida = new ContaCorrenteValidation();
		
		
		if (valida.validaID(idConta)==true) {
		
		List<ContaCorrente> contas = dao.getOneCC(idConta);
		
		System.out.println("Conta adquirida:");
		for (ContaCorrente clien : contas) {
			System.out.printf("ID conta: %02d\t|Saldo: R$ %.2f\t | Tipo conta: %s%n", clien.getId(), clien.getSaldo(),
					clien.getTipo());
		}
		System.out.println();
		return contas; 
		} else {
			return null;
		}
		
	}/*getOneAccount*/
	
	public void depositar (int idConta, double valor) throws ConexaoException {
		
		valida = new ContaCorrenteValidation();
		if (valida.validaID(idConta) == true) {
			if(valida.valorDeposito(valor) == true) {
			
				calculo = new Calculo();
				calculo.depositar(idConta, valor);
			
			}
		} else {
			System.out.println("...por favor confirme o numero da conta.");
		}
	}
	
	public void sacar (int idConta, double valor) throws ConexaoException {
		
		valida = new ContaCorrenteValidation();
		if(valida.validaID(idConta)==true) {
			calculo = new Calculo();
			calculo.sacar(idConta, valor);
		}else {
			System.out.println("Operação não foi realizada.");
		}
		
	}
	
	
	
	
	
	
	

}/* ContaCorrenteController */
