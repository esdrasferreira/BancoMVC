package banco.model.controller;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ClienteDAO;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.service.validation.ContaCorrenteValidation;

public class ContaCorrenteController {

	ContaCorrenteDAO dao;
	ContaCorrenteValidation valida;

	public ContaCorrenteController() throws ConexaoException {
		this.dao = new ContaCorrenteDAO();
	}


	
	ClienteDAO cdao = new ClienteDAO();
	
	
	
	
	
	
	
	
	
	
}/* ContaCorrenteController */
