package br.com.lopes.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lopes.game.model.Game;

public interface GameRepository extends JpaRepository<Game ,Long>{

}
