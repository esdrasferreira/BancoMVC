package banco.model.service.validation;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ClienteDAO;
import banco.model.entity.Cliente;

public class ClienteValidation {

	private ClienteDAO dao;

	public boolean validaNome(Cliente cliente) {

		if (cliente.getNome().matches("[a-zA-Z]+")) {
			System.out.println("Nome validado.");
			return true;
		} else {
			System.out.println("Nome invalido, deve conter apenas letras no nome.");
			return false;
		}

	}/* validaNome */

	public boolean validaEnd(Cliente cliente) {

		if (cliente.getEnd() == null) {

			System.out.println("Campo endereço é obrigatório");
			return false;
		} else {
			System.out.println("Endereço validado.");

			return true;
		}
	}/* validaEnd */

	public boolean validaID(int ID) throws ConexaoException {

		dao = new ClienteDAO();
		List<Cliente> pessoas = dao.getAllClienteBD();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getIdCliente() == ID) {
				//System.out.println("existe");
				return true;

			}
		}
		System.out.println("ID de cliente não existe no sistema.");
		return false;
	}/*validaID*/

}/* ClienteValidation */
