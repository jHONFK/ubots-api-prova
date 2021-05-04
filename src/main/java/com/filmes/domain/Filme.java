package com.filmes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;


    public boolean isAvaliado() {
        return avaliado;
    }

    public void setAvaliado(boolean avaliado) {
        this.avaliado = avaliado;
    }

    //0 para não avaliado e 1 para avaliado, para filtrar, 0 é não filmes não avaliados
    private boolean avaliado;


    public Filme(){

    }

    public Filme(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
