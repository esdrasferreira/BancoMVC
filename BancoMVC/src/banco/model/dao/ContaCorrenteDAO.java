package banco.model.dao;

import java.sql.Connection;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.conexao.factory.jdbc.FabricaConexao;
import banco.model.entity.ContaCorrente;

public class ContaCorrenteDAO {
	
	private Connection conn;
	
	public ContaCorrenteDAO() throws ConexaoException{
		try {

			this.conn = FabricaConexao.getConexao();
		} catch (Exception e) {
			throw new ConexaoException("Erro: " + e.getMessage());
		}
	}
	
	public void deposito(ContaCorrente ID) {
		
		
	}
	
	
	
	
	

}
