package com.filmes.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmeService {
    private FilmeRepository rep;
    public Iterable<Filme> getFilmes(){
        return rep.findAll();
    }
    public Iterable<Filme> getFilmesByAvaliado(boolean avaliado){
        return rep.findByAvaliado(avaliado);
    }
    public List<Filme> getFilmesFake(){
        List<Filme> filmes = new ArrayList<>();

        filmes.add(new Filme(1L,"Harry Potter e a Pedra Filosofal"));
        filmes.add(new Filme(2L,"O Voo"));
        filmes.add(new Filme(3L,"Bastardos Inglorios"));
        return filmes;
    }

    public Filme save(Filme filme) {
        return rep.save(filme);
    }

    public Filme update(Filme filme, Long id) {
        Optional<Filme> optional = getFilmesById(id);
        if (optional.isPresent()) {
            Filme db = optional.get();
            db.setNome(filme.getNome());
            db.setAvaliado(filme.isAvaliado());
            rep.save(db);
            return db;
        }

        else{
            throw new RuntimeException("Erro na atualização");
        }

    }

    public Optional<Filme> getFilmesById(Long id) {
        return rep.findById(id);
    }

    public void delete(Long id) {
        Optional<Filme> filme = getFilmesById(id);
        if(filme.isPresent()){
            rep.deleteById(id);
        }
    }
}
