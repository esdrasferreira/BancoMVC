package banco.model.service.validation;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.ContaCorrente;

public class ContaCorrenteValidation {
	
	private ContaCorrenteDAO dao;
	
	
	public boolean validaSaldo(ContaCorrente cc) {

		if (cc.getSaldo() != null) {
			System.out.println("saldo validado");
			return true;
			
		}else {
			System.out.println("Saldo não pode conter valor nulo");
			return false;
		}
		
		
		
		
	}/*validaSaldo*/
	
	public boolean validaTipo(ContaCorrente cc) {
		
		String c = "comum";
		String p = "personalite";

		if (cc.getTipo() == c || cc.getTipo() == p) {

			System.out.println("Tipo validado");
			return true;
		} else {
			System.out.println("Tipo invalido, deve ser " +c+" ou "+p);

			return false;
		}
	}/*validaTipo*/
	
	
	public boolean validaCC(ContaCorrente conta) {

		if (conta.getTipo().contentEquals("comun") || conta.getTipo().contentEquals("personalite")) {
			System.out.println("Tipo de conta: validado! Sua conta é: " + conta.getTipo());
			if (conta.getSaldo() != null) {
				System.out.println("Saldo validado!");
				return true;
			} else {
				System.out.println("Saldo deve ser preenchido");
				return false;
			}
		} else {
			System.out.println("Tipo de conta deve ser: comun ou personalite");
			return false;
		}

	}/*validaCC*/

	public boolean validaID(int ID) throws ConexaoException {

		dao = new ContaCorrenteDAO();
		List<ContaCorrente> pessoas = dao.getAllCCfromBD();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getId() == ID) {
				//System.out.println("existe");
				return true;

			}
		}
		System.out.println("ID de conta não encotrado.");
		return false;
	}/*validaID*/
	
	public boolean valorDeposito(double valor) {
		
		if(valor > 0) {
			return true;
		}else {
			System.out.println("Valor de deposito inválido, deve ser valor maior que ZERO.");
			return false;
		}
		
		
	}/*valorDeposito*/
	
	
	
	
	
	
	
	
	

}
