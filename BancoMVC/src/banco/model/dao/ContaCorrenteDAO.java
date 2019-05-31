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
import banco.model.entity.ContaCorrente;

public class ContaCorrenteDAO {

	private Connection conn;

	public ContaCorrenteDAO() throws ConexaoException {
		try {

			this.conn = FabricaConexao.getConexao();
		} catch (Exception e) {
			throw new ConexaoException("Erro: " + e.getMessage());
		}
	}

	public List<ContaCorrente> getAllCCfromBD() throws ConexaoException {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		ContaCorrente conta = null;

		try {
			conn = this.conn;
			st = conn.prepareStatement("SELECT * FROM contacorrente");
			rs = st.executeQuery();

			List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

			while (rs.next()) {

				conta = new ContaCorrente(rs.getInt(1), rs.getDouble(2), rs.getString(3));

				contas.add(conta);
			}
//			System.out.println("Lista de todos os clientes:");
//			for (ContaCorrente clien : contas) {
//				System.out.printf("ID conta: %02d\t|Saldo: R$ %.2f\t | Tipo conta: %s%n", clien.getId(),
//						clien.getSaldo(), clien.getTipo());
//			}
//			System.out.println();
			return contas;

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {

			FabricaConexao.fecharStmtRs(st, rs);
		}

	}/* getAllCCfromBD */

	public List<ContaCorrente> getOneCC(int idConta) throws ConexaoException {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		ContaCorrente conta = null;

		try {
			conn = this.conn;
			st = conn.prepareStatement(
					"SELECT * FROM bancomvc.contacorrente\r\n" + "where contacorrente.idconta = '" + idConta + "'");
			rs = st.executeQuery();

			List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

			while (rs.next()) {

				conta = new ContaCorrente(rs.getInt(1), rs.getDouble(2), rs.getString(3));

				contas.add(conta);
			}

			return contas;

		} catch (SQLException sqle) {
			throw new ConexaoException("Erro ao visualizar os dados" + sqle);
		} finally {

			FabricaConexao.fecharStmtRs(st, rs);
		}

	}/* getOneCC */

	public void updateSaldo(ContaCorrente conta) throws ConexaoException {

		Connection conn = null;
		Statement st = null;

		try {
			conn = this.conn;
			st = conn.createStatement();

			int idConta = conta.getId();
			double saldo = conta.getSaldo();
			String tipo = conta.getTipo();

			st.executeUpdate("UPDATE `bancomvc`.`contacorrente` SET `saldo` = '" + saldo + "', `tipo` = '" + tipo
					+ "' WHERE (`idconta` = '" + idConta + "')");

			System.out.println("...conta atualizada com sucesso.");

		} catch (SQLException sqle) {
			throw new ConexaoException();
		} finally {
			FabricaConexao.fecharStatement(st);
		}

	}/* updateSaldo */

}/* ContaCorrenteDAO */
