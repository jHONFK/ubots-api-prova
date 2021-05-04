package com.filmes.api;


import com.filmes.domain.Filme;
import com.filmes.domain.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/filmes")
public class FilmesController {
    @Autowired
    private FilmeService service;
    @GetMapping
    public Iterable<Filme> get(){
        return service.getFilmes();
    }

    @GetMapping("/{id}")
    public Optional<Filme> get(@PathVariable("id") Long id){
        return service.getFilmesById(id);
    }

    @GetMapping("/avaliado/{avaliado}")
    public Iterable<Filme> getFilmesByAvaliado(@PathVariable("avaliado") boolean avaliado){
        return service.getFilmesByAvaliado(avaliado);
    }

    @PostMapping
    public void post(@RequestBody Filme filme){
        service.save(filme);
    }

    @PutMapping("{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Filme filme){
        service.update(filme, id);
        return "Filme atualizado";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "Filme apagado";
    }




}
