package br.com.caelum.ingresso.validacao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoTest {
	
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalamaisOPrecoDoFilme(){
		
		Sala sala = new Sala("Eldorado - IMAX",new BigDecimal("22.5"));
		
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120),"SCI-FI", new BigDecimal("22.5"));
		
		BigDecimal somaDosPrecosDaSalaeFilme = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao(LocalTime.now(),filme,sala);
		
		assertEquals(somaDosPrecosDaSalaeFilme, sessao.getPreco());
				
	} 

}
