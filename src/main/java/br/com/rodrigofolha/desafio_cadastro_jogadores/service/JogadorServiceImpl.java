package br.com.rodrigofolha.desafio_cadastro_jogadores.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.rodrigofolha.desafio_cadastro_jogadores.model.GrupoCodinome;
import br.com.rodrigofolha.desafio_cadastro_jogadores.model.Jogador;
import br.com.rodrigofolha.desafio_cadastro_jogadores.repository.JogadorRepository;

@Component
public class JogadorServiceImpl implements JogadorService {
    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    public JogadorServiceImpl(JogadorRepository jogadorRepository, CodinomeService codinomeService) {
        this.jogadorRepository = jogadorRepository;
        this.codinomeService = codinomeService;
    }

    @Override
    public Jogador registrarJogador(Jogador jogador) throws Exception {
        var codinomesEmUso = listarCodinomesEmUso(jogador.getGrupoCodinome());
        var novoCodinome = codinomeService.gerarCodinome(jogador.getGrupoCodinome(), codinomesEmUso);
        
        var novoJogador = new Jogador(
            jogador.getNome(),
            jogador.getEmail(),
            jogador.getTelefone(),
            novoCodinome,
            jogador.getGrupoCodinome()
        );
        return jogadorRepository.salvar(novoJogador);
    }

    private List<String> listarCodinomesEmUso(GrupoCodinome grupoCodinome) {
        return jogadorRepository.listarCodinomesPorGrupo(grupoCodinome);
    }

    @Override
    public List<Jogador> listarJogadores() {
        return jogadorRepository.listarJogadores();
    }

}
