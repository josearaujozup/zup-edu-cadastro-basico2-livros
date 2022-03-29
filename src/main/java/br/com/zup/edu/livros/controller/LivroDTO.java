package br.com.zup.edu.livros.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.edu.livros.models.Livro;

public class LivroDTO {
	
	@NotBlank
	@Length(max = 200)
	private String titulo;
	
	@NotBlank
	@Length(max = 4000)
	private String descricao;
	
	@NotNull
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao; 
	
	@NotNull
	@ISBN
	private String isbn;

	public LivroDTO(@NotBlank @Length(max = 200) String titulo, @NotBlank @Length(max = 4000) String descricao,
			@NotNull @Past LocalDate dataPublicacao, @NotNull @org.hibernate.validator.constraints.ISBN String isbn) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataPublicacao = dataPublicacao;
		isbn = isbn;
	}
	
	
	public LivroDTO() {
		
	}
	
	public Livro paraLivro() {
		return new Livro(titulo, descricao, dataPublicacao, isbn);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getIsbn() {
		return isbn;
	}
	
}
