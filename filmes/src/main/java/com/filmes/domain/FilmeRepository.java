package com.filmes.domain;

import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme,Long> {
    Iterable<Filme> findByAvaliado(boolean avaliado);
}
