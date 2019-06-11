package banco.model.service.validation;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.ContaCorrente;

/**
 * Classe ContaCorrenteValidation realiza validações especificas antes de
 * permitir operações relacionadas a conta corrente.
 * 
 * @author esdras
 * @since 06/11/2019
 * @version 1.0.2
 */
public class ContaCorrenteValidation {

	private ContaCorrenteDAO dao;

	/**
	 * Método validaSaldo verifica se o valor que o usuário está realiando SET como
	 * SALDO não é nulo. Antes de permitir salvar o saldo.
	 * 
	 * @param cc
	 * @return true or false
	 */

	public boolean validaSaldo(ContaCorrente cc) {

		if (cc.getSaldo() != null) {
			System.out.println("saldo validado");
			return true;

		} else {
			System.out.println("Saldo não pode conter valor nulo");
			return false;
		}

	}/* validaSaldo */

	/**
	 * Método validaTipo compara se o tipo de conta corrente inserido pelo usuário
	 * está de acordo com os tipos de contas disponíveis no banco para realizar o
	 * cadastro e retorna mensagem avisando de está correto ou não.
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
	 * Método validaCC além de verificar o tipo de conta como o método validaTipo
	 * faz, este método ainda verifica se o valor de saldo está correto.
	 * 
	 * @param conta
	 * @return true or false
	 */

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

	}/* validaCC */

	/**
	 * Método validaID recebe o ID pelo input do usuário e verifica no banco de
	 * dados se existe, retornando os dados do ID ou informando que não foi
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
		System.out.println("ID de conta não encotrado.");
		return false;
	}/* validaID */

	/**
	 * Método valorDeposito verifica se o valor do depósito é maior do que zero
	 * antes de permitir realizar o depósito e retorna false e mensagem de aviso
	 * alertando se o valor estiver incorreto. Senão retorna true.
	 * 
	 * @param valor
	 * @return true or false
	 */

	public boolean valorDeposito(double valor) {

		if (valor > 0) {
			return true;
		} else {
			System.out.println("Valor de deposito inválido, deve ser valor maior que ZERO.");
			return false;
		}

	}/* valorDeposito */

}
