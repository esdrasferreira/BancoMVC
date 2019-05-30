package banco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.conexao.factory.jdbc.FabricaConexao;
import banco.model.entity.Cliente;


public class ClienteDAO {

	private Connection conn;

	public ClienteDAO() throws ConexaoException {

		try {

			this.conn = FabricaConexao.getConexao();
		} catch (Exception e) {
			throw new ConexaoException("Erro: " + e.getMessage());
		}

	}
	
	public void addCliente(Cliente cliente) throws ConexaoException {

		PreparedStatement ps = null;
		Connection conexao = null;

		try {

			conexao = this.conn;
			ps = conexao.prepareStatement("INSERT INTO cliente (idcliente, nome, cpf, end ) values (?, ?, ?, ?)");
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getEnd());
		
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharPreparedStatement(ps);
		}
	}/* end addCliente */
	
	
	public void delCliente(int ID) throws ConexaoException {

		Statement st = null;
		Connection conexao = null;

		try {

			conexao = this.conn;
			st = conexao.createStatement();
			st.executeUpdate("delete from cliente WHERE (`idcliente` = '" + ID + "')");
			

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharStatement(st);
		}
	}/* end delCliente */
	
	public List<Cliente> getAllClienteBD() throws ConexaoException {

		Connection conexao = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Cliente p = null;

		try {
			conexao = this.conn;
			st = conexao.prepareStatement("SELECT * FROM cliente");
			rs = st.executeQuery();

			List<Cliente> pessoas = new ArrayList<Cliente>();

			while (rs.next()) {

				p = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

				pessoas.add(p);
			}
			System.out.println("Lista de todos os clientes:");
			for (Cliente clien : pessoas) {
				System.out.printf("ID: %d\t|Nome: %s\t CPF: %s End: %s%n", clien.getIdCliente(), clien.getNome(), clien.getCpf(), clien.getEnd());
			} 
			System.out.println();
			return pessoas;
			
		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {
			
			FabricaConexao.fecharStmtRs(st, rs);
		}
		
	}/* end getClienteFromBD*/
	
	public void listaAllCliente()throws ConexaoException{
		
		
		List<Cliente> pessoas = this.getAllClienteBD();
		
		
				System.out.println("Lista de todos os clientes:");
				for (Cliente clien : pessoas) {
					System.out.printf("IID: %d\\t|Nome: %s\\t CPF: %s End: %s%n", clien.getIdCliente(), clien.getNome(), clien.getCpf(), clien.getEnd());
				} 

		}// end listaTodoCliente
	
	
	
	
	
	
	
	
	
	
	

	public void fecharConexao() throws ConexaoException {
		FabricaConexao.fecharConexao(conn);

	}// end fecharConexao

}
