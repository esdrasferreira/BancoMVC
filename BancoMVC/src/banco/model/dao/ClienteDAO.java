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
import banco.model.entity.ContaCorrente;

public class ClienteDAO {

	private Connection conn;

	public ClienteDAO() throws ConexaoException {

		try {

			this.conn = FabricaConexao.getConexao();
		} catch (Exception e) {
			throw new ConexaoException("Erro: " + e.getMessage());
		}

	}

	public void addCliente(Cliente cliente) throws ConexaoException, SQLException {

		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;

		try {
			conn = this.conn;
			st = conn.createStatement();

			int idConta = 0;
			Double saldo = 0.0;
			String tipo = "comun";

			st.executeUpdate("INSERT INTO contacorrente (idconta, saldo, tipo) values ('" + idConta + "', '" + saldo
					+ "', '" + tipo + "')", Statement.RETURN_GENERATED_KEYS);

			int autoIncKeyFromApi = -1;
			rs = st.getGeneratedKeys();

			if (rs.next()) {
				autoIncKeyFromApi = rs.getInt(1);

			} else {
				throw new ConexaoException();
			}

			int idCliente = cliente.getIdCliente();
			String nome = cliente.getNome();
			String cpf = cliente.getCpf();
			String end = cliente.getEnd();
			int idContaC = autoIncKeyFromApi;

			st.executeUpdate("INSERT INTO cliente (idcliente, nome, cpf, end, contaCorrente_idconta ) values ('" + idCliente + "', '"
					+ nome + "', '" + cpf + "', '" + end + "', '" + idContaC + "')");
			
			
			st.executeUpdate("INSERT INTO `bancomvc`.`poupanca` (`saldo`, `contaCorrente_idconta`) VALUES ('0', '"+idContaC+"')");
			
			System.out.println("...conta criada com sucesso.");

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharStatement(st);
		}
	}/* end addCliente */

	public void delCliente(int ID) throws ConexaoException {

		Statement st = null;
		Connection conn = null;

		try {

			conn = this.conn;
			st = conn.createStatement();
			st.executeUpdate("delete from cliente WHERE (`idcliente` = '" + ID + "')");

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharStatement(st);
		}
	}/* end delCliente */

	public List<Cliente> getAllClienteBD() throws ConexaoException {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Cliente p = null;

		try {
			conn = this.conn;
			st = conn.prepareStatement("SELECT * FROM cliente");
			rs = st.executeQuery();

			List<Cliente> pessoas = new ArrayList<Cliente>();

			while (rs.next()) {

				p = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

				pessoas.add(p);
			}
//			System.out.println("Lista de todos os clientes:");
//			for (Cliente clien : pessoas) {
//				System.out.printf("ID cliente: %02d\t|Nome: %s\t | CPF: %s | End: %s | IDconta: %02d%n", clien.getIdCliente(),
//						clien.getNome(), clien.getCpf(), clien.getEnd(), clien.getIdConta());
//			}
			
			return pessoas;

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {

			FabricaConexao.fecharStmtRs(st, rs);
		}

	}/* end getClienteFromBD */

	

	public void fecharConexao() throws ConexaoException {
		FabricaConexao.fecharConexao(conn);

	}// end fecharConexao

}
