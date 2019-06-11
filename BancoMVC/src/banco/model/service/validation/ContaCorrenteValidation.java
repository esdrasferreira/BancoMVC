package banco.model.service.validation;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.ContaCorrente;

/**
 * Classe ContaCorrenteValidation realiza valida��es especificas antes de
 * permitir opera��es relacionadas a conta corrente.
 * 
 * @author esdras
 * @since 06/11/2019
 * @version 1.0.2
 */
public class ContaCorrenteValidation {

	private ContaCorrenteDAO dao;

	/**
	 * M�todo validaSaldo verifica se o valor que o usu�rio est� realiando SET como
	 * SALDO n�o � nulo. Antes de permitir salvar o saldo.
	 * 
	 * @param cc
	 * @return true or false
	 */

	public boolean validaSaldo(ContaCorrente cc) {

		if (cc.getSaldo() != null) {
			System.out.println("saldo validado");
			return true;

		} else {
			System.out.println("Saldo n�o pode conter valor nulo");
			return false;
		}

	}/* validaSaldo */

	/**
	 * M�todo validaTipo compara se o tipo de conta corrente inserido pelo usu�rio
	 * est� de acordo com os tipos de contas dispon�veis no banco para realizar o
	 * cadastro e retorna mensagem avisando de est� correto ou n�o.
	 * 
	 * @param cc
	 * @return true or false
	 */

	public boolean validaTipo(ContaCorrente cc) {

		String c = "comum";
		String p = "personalite";

		if (cc.getTipo() == c || cc.getTipo() == p) {

			System.out.println("Tipo validado");
			return true;
		} else {
			System.out.println("Tipo invalido, deve ser " + c + " ou " + p);

			return false;
		}
	}/* validaTipo */

	/**
	 * M�todo validaCC al�m de verificar o tipo de conta como o m�todo validaTipo
	 * faz, este m�todo ainda verifica se o valor de saldo est� correto.
	 * 
	 * @param conta
	 * @return true or false
	 */

	public boolean validaCC(ContaCorrente conta) {

		if (conta.getTipo().contentEquals("comun") || conta.getTipo().contentEquals("personalite")) {
			System.out.println("Tipo de conta: validado! Sua conta �: " + conta.getTipo());
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

	}/* validaCC */

	/**
	 * M�todo validaID recebe o ID pelo input do usu�rio e verifica no banco de
	 * dados se existe, retornando os dados do ID ou informando que n�o foi
	 * encontrado.
	 * 
	 * 
	 * @param ID
	 * @return true or false
	 * @throws ConexaoException
	 */

	public boolean validaID(int ID) throws ConexaoException {

		dao = new ContaCorrenteDAO();
		List<ContaCorrente> pessoas = dao.getAllCCfromBD();

		for (ContaCorrente contaCorrente : pessoas) {
			if (pessoas == pessoas.get(ID)) {
				// System.out.println("existe");
				return true;
			}
		}

//		for (int i = 0; i < pessoas.size(); i++) {
//			if (pessoas.get(i).getId() == ID) {
//				//System.out.println("existe");
//				return true;
//			}
//		}
		System.out.println("ID de conta n�o encotrado.");
		return false;
	}/* validaID */

	/**
	 * M�todo valorDeposito verifica se o valor do dep�sito � maior do que zero
	 * antes de permitir realizar o dep�sito e retorna false e mensagem de aviso
	 * alertando se o valor estiver incorreto. Sen�o retorna true.
	 * 
	 * @param valor
	 * @return true or false
	 */

	public boolean valorDeposito(double valor) {

		if (valor > 0) {
			return true;
		} else {
			System.out.println("Valor de deposito inv�lido, deve ser valor maior que ZERO.");
			return false;
		}

	}/* valorDeposito */

}
