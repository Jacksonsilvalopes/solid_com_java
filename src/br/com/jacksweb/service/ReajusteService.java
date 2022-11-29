package br.com.jacksweb.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.jacksweb.ValidacaoException;
import br.com.jacksweb.model.Funcionario;

public class ReajusteService {
	
	public void reajustarSalarioFuncionario(Funcionario funcionario,BigDecimal aumento ) {
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual , RoundingMode.HALF_UP);
		if(percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("O reajuste não pode ser superior a 40% do salario");
		}
		
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizaSalario(salarioReajustado);
		
	}

}
