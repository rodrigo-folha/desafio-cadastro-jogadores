package br.com.rodrigofolha.desafio_cadastro_jogadores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rodrigofolha.desafio_cadastro_jogadores.model.GrupoCodinome;

@Service
public interface CodinomeService {
    
    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception;

}
