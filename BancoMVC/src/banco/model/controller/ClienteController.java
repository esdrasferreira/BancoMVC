package banco.model.controller;

import java.sql.SQLException;
import java.util.List;
import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ClienteDAO;
import banco.model.entity.Cliente;
import banco.model.service.validation.ClienteValidation;
import banco.model.service.validation.ContaCorrenteValidation;

public class ClienteController {

	private ClienteDAO dao;
	ClienteValidation valida = new ClienteValidation();
	ContaCorrenteValidation validacc = new ContaCorrenteValidation();

	public ClienteController() throws ConexaoException {
		this.dao = new ClienteDAO();
	}

	public void exeInsert(Cliente cliente) throws ConexaoException, SQLException {

		if (valida.validaNome(cliente) == true) {
			System.out.println("confirmado nome validado....verificando endere�o...");
			if (valida.validaEnd(cliente) == true) {
				System.out.println("dados validados....criando conta e usu�rio...");
				dao.addCliente(cliente);
			} else {
				System.out.println("Ender�o invalido.");
			}
		} else {
			System.out.println("Nome invalido");
		}
	}/* exeInsert */

	public void listaClientes() throws ConexaoException {

		dao = new ClienteDAO();
		List<Cliente> pessoas = dao.getAllClienteBD();
		System.out.println("Lista de todos os clientes:");
		for (Cliente clien : pessoas) {
			System.out.printf("ID cliente: %02d\t|Nome: %s\t | CPF: %s | End: %s | IDconta: %02d%n",
					clien.getIdCliente(), clien.getNome(), clien.getCpf(), clien.getEnd(), clien.getIdConta());
		}

	}

	public String delCliente(int ID) throws ConexaoException {

		dao = new ClienteDAO();
		if (valida.validaID(ID)==true) {
			dao.delCliente(ID);
			String del = "Cliente deletado";
			System.out.println(del);
			return del;
		}else {
			String del = "ID n�o existe no sistema.";
			System.out.println(del);
			return del;
		}
		

	}
	

	
	
	
	
	
	
	
	
	
	
	

}/* ClienteController */