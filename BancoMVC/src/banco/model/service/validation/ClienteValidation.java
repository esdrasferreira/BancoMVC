package banco.model.service.validation;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ClienteDAO;
import banco.model.entity.Cliente;

/**
 * Classe ClienteValidation, responsável por realizar algumas validações antes
 * de permites certas operações realizadas especificamente aos clientes.
 * 
 * @author esdras
 * @since 06/11/2019
 * @version 1.0.2
 */

public class ClienteValidation {

	private ClienteDAO dao;

	/**
	 * Método validaNome, verifica se o nome do cliente possui apenas letras antes
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
	 * Método validaEnd, verifica se o campo endereço foi preenchido antes de
	 * adiciona-lo ao cadastro.
	 * 
	 * @param cliente
	 * @return true or false
	 */

	public boolean validaEnd(Cliente cliente) {

		if (cliente.getEnd() == null) {

			System.out.println("Campo endereço é obrigatório");
			return false;
		} else {
			System.out.println("Endereço validado.");

			return true;
		}
	}/* validaEnd */

	/**
	 * Método validaID realiza a verificação se o ID fornecido pelo usuário existe
	 * no banco de dados. Se verdadeiro retorna o cadastro se falso retorna mensagem
	 * avisando que não existe o ID fornecido.
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
		System.out.println("ID de cliente não existe no sistema.");
		return false;
	}/* validaID */

}/* ClienteValidation */
