package banco.model.usaSistema;

import java.sql.SQLException;
import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.controller.ClienteController;
import banco.model.controller.ContaCorrenteController;
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

/***************************************************************************************************************/		
		
		ContaCorrenteController ccc = new ContaCorrenteController();
		
		ccc.getContas();
		ccc.getOneAccount(7);
		ccc.depositar(07, 500.00);
		ccc.getOneAccount(07);
		ccc.sacar(7, 100);
		
		

	}

}
