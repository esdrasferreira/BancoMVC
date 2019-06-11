package banco.model.service.validation;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ClienteDAO;
import banco.model.entity.Cliente;

/**
 * Classe ClienteValidation, respons�vel por realizar algumas valida��es antes
 * de permites certas opera��es realizadas especificamente aos clientes.
 * 
 * @author esdras
 * @since 06/11/2019
 * @version 1.0.2
 */

public class ClienteValidation {

	private ClienteDAO dao;

	/**
	 * M�todo validaNome, verifica se o nome do cliente possui apenas letras antes
	 * de permitir adicionar o cadastro.
	 * 
	 * @param cliente
	 * @return true or false
	 */

	public boolean validaNome(Cliente cliente) {

		if (cliente.getNome().matches("[a-zA-Z]+")) {
			System.out.println("Nome validado.");
			return true;
		} else {
			System.out.println("Nome invalido, deve conter apenas letras no nome.");
			return false;
		}

	}/* validaNome */

	/**
	 * M�todo validaEnd, verifica se o campo endere�o foi preenchido antes de
	 * adiciona-lo ao cadastro.
	 * 
	 * @param cliente
	 * @return true or false
	 */

	public boolean validaEnd(Cliente cliente) {

		if (cliente.getEnd() == null) {

			System.out.println("Campo endere�o � obrigat�rio");
			return false;
		} else {
			System.out.println("Endere�o validado.");

			return true;
		}
	}/* validaEnd */

	/**
	 * M�todo validaID realiza a verifica��o se o ID fornecido pelo usu�rio existe
	 * no banco de dados. Se verdadeiro retorna o cadastro se falso retorna mensagem
	 * avisando que n�o existe o ID fornecido.
	 * 
	 * @param ID
	 * @return true or false
	 * @throws ConexaoException
	 */

	public boolean validaID(int ID) throws ConexaoException {

		dao = new ClienteDAO();
		List<Cliente> pessoas = dao.getAllClienteBD();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getIdCliente() == ID) {
				// System.out.println("existe");
				return true;

			}
		}
		System.out.println("ID de cliente n�o existe no sistema.");
		return false;
	}/* validaID */

}/* ClienteValidation */
