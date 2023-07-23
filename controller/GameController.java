package br.com.lopes.game.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lopes.game.model.Game;
import br.com.lopes.game.repository.GameRepository;

@RestController
@RequestMapping("/")
public class GameController {
	
	//injeta o repositoio de games na classe Game controller
	@Autowired
	private GameRepository gr;
	
	@GetMapping()
	private String testar(){
		return "Bem Vindo ao jogo";
	}
	
	@GetMapping("api/games")
	public List<Game>listar(){
		return gr.findAll();
	}
	@GetMapping("api/games/{id}")
	public Game listarPorId(@PathVariable Long id){
	return gr.findById(id).get();
	}
	@PostMapping("api/games")
	@ResponseStatus(HttpStatus.CREATED)
	public Game save(@RequestBody Game game) {
	return  gr.save(game);
		
	}
	@DeleteMapping("/api/games/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		gr.deleteById(id);
		
	}
	@PutMapping("/api/games/{id}")
		public Game atualizar(@PathVariable Long id ,@RequestBody Game game) {
		Game gameAtual = gr.findById(id).get();
		
		//pega o game atual e troca pelo objeto game que o usuario informou,mnos o id
		BeanUtils.copyProperties(game, gameAtual,"id") ;
		return gr.save(gameAtual);
	}

}
