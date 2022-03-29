package br.com.zup.edu.livros.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.livros.models.Livro;
import br.com.zup.edu.livros.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private final LivroRepository repository;
	
	public LivroController(LivroRepository repository) {
		this.repository = repository;
	}
	
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid LivroDTO request, UriComponentsBuilder uriComponentsBuilder){
		Livro novoLivro = request.paraLivro();
		
		URI location = uriComponentsBuilder.path("/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
