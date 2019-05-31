package banco.model.service.validation;

import banco.model.entity.ContaCorrente;

public class ContaCorrenteValidation {
	
	
	
	
	public boolean validaSaldo(ContaCorrente cc) {

		if (cc.getSaldo() != null) {
			System.out.println("saldo validado");
			return true;
			
		}else {
			System.out.println("Saldo não pode conter valor nulo");
			return false;
		}
		
		
		
		
	}/*validaSaldo*/
	
	public boolean validaTipo(ContaCorrente cc) {
		
		String c = "comum";
		String p = "personalite";

		if (cc.getTipo() == c || cc.getTipo() == p) {

			System.out.println("Tipo validado");
			return true;
		} else {
			System.out.println("Tipo invalido, deve ser " +c+" ou "+p);

			return false;
		}
	}/*validaTipo*/
	
	
	public boolean validaCC(ContaCorrente conta) {

		if (conta.getTipo().contentEquals("comun") || conta.getTipo().contentEquals("personalite")) {
			System.out.println("Tipo de conta: validado! Sua conta é: " + conta.getTipo());
			if (conta.getSaldo() != null) {
				System.out.println("Saldo validado!");
				return true;
			} else {
				System.out.println("Saldo deve ser preenchido");
				return false;
			}
		} else {
			System.out.println("Tipo de conta deve ser: comun ou personalite");
			return false;
		}

	}/*validaCC*/

	
	
	
	
	
	
	
	
	

}
