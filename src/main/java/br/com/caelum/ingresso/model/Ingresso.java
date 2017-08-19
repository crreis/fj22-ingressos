package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Descontos;

public class Ingresso {
	
	private Sessao sessao;
	private BigDecimal preco;
	
	/**
	 * @deprecated hibernate only
	 */
	public Ingresso() {
		
	}

	public Ingresso(Sessao sessao, Descontos tipoDeDesconto) {
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
	}

	public Sessao getSessao() {
		return sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
}
