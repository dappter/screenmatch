package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByTituloContainingIgnoreCase(String titulo);
    List<Filme> findByGenero(String genero);
    List<Filme> findByAno(Integer ano);
}
