package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.FilmeDTO;
import br.com.alura.screenmatch.exception.ResourceNotFoundException;
import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<FilmeDTO> listarTodos() {
        return repository.findAll().stream()
                .map(FilmeDTO::new)
                .collect(Collectors.toList());
    }

    public FilmeDTO buscarPorId(Long id) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com ID: " + id));
        return new FilmeDTO(filme);
    }

    public FilmeDTO criar(FilmeDTO dto) {
        Filme filme = new Filme();
        filme.setTitulo(dto.getTitulo());
        filme.setAno(dto.getAno());
        filme.setDiretor(dto.getDiretor());
        filme.setGenero(dto.getGenero());
        
        Filme salvo = repository.save(filme);
        return new FilmeDTO(salvo);
    }

    public FilmeDTO atualizar(Long id, FilmeDTO dto) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com ID: " + id));
        
        filme.setTitulo(dto.getTitulo());
        filme.setAno(dto.getAno());
        filme.setDiretor(dto.getDiretor());
        filme.setGenero(dto.getGenero());
        
        Filme atualizado = repository.save(filme);
        return new FilmeDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Filme não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }

    public List<FilmeDTO> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo).stream()
                .map(FilmeDTO::new)
                .collect(Collectors.toList());
    }

    public List<FilmeDTO> buscarPorGenero(String genero) {
        return repository.findByGenero(genero).stream()
                .map(FilmeDTO::new)
                .collect(Collectors.toList());
    }

    public List<FilmeDTO> buscarPorAno(Integer ano) {
        return repository.findByAno(ano).stream()
                .map(FilmeDTO::new)
                .collect(Collectors.toList());
    }
}
