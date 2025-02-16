package br.com.rodrigofolha.desafio_cadastro_jogadores.repository;

import br.com.rodrigofolha.desafio_cadastro_jogadores.web.CodinomeDTO;

public interface CodinomeRepository {
    CodinomeDTO buscarCodinomes() throws Exception;
    
}
