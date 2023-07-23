package br.com.lopes.game.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tbl_game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//gerar id automatico e sequencial
	private long id;
	private String titulo;
	private String produtora;
	private String console;
	private boolean zerado;
	private int nota;
	
	//metodo gera um hash para cada instancia de objeto 
	/**
	 * Já um hashcode(código hash) é um valor inteiro associado com todos os objetos em Java.
	 *  Então, para obter esse hashcode precisamos utilizar o método hashCode(),
	 *   esse método retornará um inteiro para o objeto passado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(console, id, nota, produtora, titulo, zerado);
	}
	/**
	 * Equals é um método da classe lang.Object usado para comparar dois objetos. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(console, other.console) && id == other.id && nota == other.nota
				&& Objects.equals(produtora, other.produtora) && Objects.equals(titulo, other.titulo)
				&& zerado == other.zerado;
	}
	
	

}
