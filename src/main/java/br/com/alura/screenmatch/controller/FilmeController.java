package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.FilmeDTO;
import br.com.alura.screenmatch.service.FilmeService;
import br.com.alura.screenmatch.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
@CrossOrigin(origins = "*")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @Autowired
    private OmdbService omdbService;

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listarTodos() {
        try {
            return ResponseEntity.ok(service.listarTodos());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> criar(@RequestBody FilmeDTO dto) {
        try {
            System.out.println("Recebendo POST: " + dto);
            FilmeDTO criado = service.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @RequestBody FilmeDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/titulo/{titulo}")
    public ResponseEntity<List<FilmeDTO>> buscarPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(service.buscarPorTitulo(titulo));
    }

    @GetMapping("/buscar/genero/{genero}")
    public ResponseEntity<List<FilmeDTO>> buscarPorGenero(@PathVariable String genero) {
        return ResponseEntity.ok(service.buscarPorGenero(genero));
    }

    @GetMapping("/buscar/ano/{ano}")
    public ResponseEntity<List<FilmeDTO>> buscarPorAno(@PathVariable Integer ano) {
        return ResponseEntity.ok(service.buscarPorAno(ano));
    }

    @PostMapping("/omdb/{titulo}")
    public ResponseEntity<FilmeDTO> buscarEAdicionarOmdb(@PathVariable String titulo) {
        try {
            OmdbService.FilmeOmdbDTO filmeOmdb = omdbService.buscarFilme(titulo);
            
            if (filmeOmdb == null) {
                throw new RuntimeException("Filme não encontrado na OMDb: " + titulo);
            }
            
            FilmeDTO dto = new FilmeDTO();
            dto.setTitulo(filmeOmdb.getTitle());
            dto.setAno(Integer.parseInt(filmeOmdb.getYear()));
            dto.setDiretor(filmeOmdb.getDirector());
            dto.setGenero(filmeOmdb.getGenre().split(",")[0].trim());
            
            FilmeDTO criado = service.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Erro ao processar ano do filme");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar filme na OMDb: " + e.getMessage());
        }
    }
}
