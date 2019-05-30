package banco.model.usaSistema;

import java.sql.SQLException;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.controller.ClienteController;
import banco.model.dao.ClienteDAO;
import banco.model.entity.Cliente;
import banco.model.entity.ContaCorrente;
import banco.model.service.validation.ClienteValidation;
import banco.model.service.validation.ContaCorrenteValidation;

public class TestaMVC {

	public static void main(String[] args) throws ConexaoException, SQLException {

//		Cliente cliente = new Cliente(0, "Hulk", "05", "RD", 0);
		
		ClienteController controle = new ClienteController();
//		controle.exeInsert(cliente);
		controle.listaClientes();
		controle.delCliente(2);

		
		
		
		
		

	}

}
