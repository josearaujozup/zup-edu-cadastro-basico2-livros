package br.com.zup.edu.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.livros.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
