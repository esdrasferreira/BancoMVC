package banco.model.service.calculos;

import java.util.List;

import banco.conexao.factory.jdbc.ConexaoException;
import banco.model.dao.ContaCorrenteDAO;
import banco.model.entity.ContaCorrente;

/**
 * <p>
 * Classe destinada a realizar a parte matem�tica/c�lculos relacionadas a
 * tarifas do banco.
 * </p>
 * 
 * @author esdras
 *
 */

public class Calculo {
	private ContaCorrenteDAO dao;

	/**
	 * M�todo depositar, respons�vel por realizar o dep�sito adicionando ao saldo
	 * atual o valor do dep�sito.
	 * 
	 * @author esdras
	 * @since 06/11/2019
	 * @version 1.0.2
	 */

	public void depositar(int idConta, double valor) throws ConexaoException {
		dao = new ContaCorrenteDAO();
		List<ContaCorrente> contas = dao.getOneCC(idConta);

		double saldo = valor + contas.get(0).getSaldo();
		contas.get(0).setSaldo(saldo);

		dao.updateSaldo(contas.get(0));

	}/* depositar */

	/**
	 * M�todo sacar, respons�vel por subtrair o valor sacado do saldo, tamb�m
	 * realiza verifica��o se existe o saldo dispon�vel.
	 * 
	 * @param idConta
	 * @param valor
	 * @throws ConexaoException
	 */

	public void sacar(int idConta, double valor) throws ConexaoException {
		dao = new ContaCorrenteDAO();
		List<ContaCorrente> contas = dao.getOneCC(idConta);

		if (valor > contas.get(0).getSaldo()) {
			System.out.println("Valor do saque maior que o valor disponivel, saldo: R$ " + contas.get(0).getSaldo());
		} else {
			double saldo = contas.get(0).getSaldo() - valor;
			contas.get(0).setSaldo(saldo);

			dao.updateSaldo(contas.get(0));
			System.out.println("Saque realizado com sucesso, saldo dispon�vel: R$ " + contas.get(0).getSaldo());
		}

	}/* sacar */

}/* Calculo */
