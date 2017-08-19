package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Integer id;
	private LocalTime horario;
	private BigDecimal preco;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	@OneToMany
	private List<Ingresso> ingressos;
	
	/**
	 * @deprecated hibernate only
	 */
	
	public Sessao(){	
	}
	
	public Sessao(LocalTime horario, Filme filme, Sala sala){
		
		this.horario = horario;
		this.setFilme(filme);
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
		
	}
	
	public Sala getSala(){
		return  sala;
	}
	
	public void setSala(Sala sala){
		this.sala = sala;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public LocalTime getHorarioTermino(){
		return this.horario.plus(filme.getDuracao().toMinutes(), ChronoUnit.MINUTES);
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public Map<String , List<Lugar>> getMapaDeLugares(){
		return sala.getMapaDeLugares();
	}
	

	public boolean isDisponivel(Lugar lugar){
		return ingressos.stream().map(Ingresso::getLugar).noneMatch(l -> l.equals(lugar));
	}
}
