package banco.conexao.factory.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaConexao {
	
	
	public static Connection getConexao() throws ConexaoException {

		String url = "jdbc:mysql://localhost/locadora?useTimezone=true&serverTimezone=UTC";

		try {
			return DriverManager.getConnection(url, "root", "BKUgcH3YTpnexdJ");

		} catch (SQLException e) {
			throw new ConexaoException();
		}
	}

	public static void fecharConexao(Connection conexao) throws ConexaoException {
		fecharTudo(conexao, null, null, null);
	}

	public static void fecharStatement(Statement stmt) throws ConexaoException {
		fecharTudo(null, stmt, null, null);
	}
	
	public static void fecharResultSet(ResultSet rs) throws ConexaoException {
		fecharTudo(null, null, rs, null);
	}
	
	public static void fecharPreparedStatement(PreparedStatement ps) throws ConexaoException {
		fecharTudo(null, null, null, ps);
	}
	
	public static void fecharStmtRs(Statement stmt, ResultSet rs) throws ConexaoException {
		fecharTudo(null, stmt, rs, null);
		
	}

	public static void fecharTudo(Connection conn, Statement stmt, ResultSet rs, PreparedStatement ps) throws ConexaoException {

		try {
			if (conn != null)conn.close();
			if (rs != null)rs.close();
			if (ps != null)ps.close();
			if (stmt != null)stmt.close();
		} catch (SQLException e) {
			throw new ConexaoException(e.getMessage());
		}
	}
	
	
	
	
	
	

}
