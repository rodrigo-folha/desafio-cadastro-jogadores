package br.com.rodrigofolha.desafio_cadastro_jogadores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rodrigofolha.desafio_cadastro_jogadores.model.Jogador;

@Service
public interface JogadorService {
    public Jogador registrarJogador(Jogador jogador) throws Exception;

    public List<Jogador> listarJogadores();
}
