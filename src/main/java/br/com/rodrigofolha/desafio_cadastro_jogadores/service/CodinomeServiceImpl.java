package br.com.rodrigofolha.desafio_cadastro_jogadores.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.rodrigofolha.desafio_cadastro_jogadores.exception.GrupoCodinomeIndisponivelException;
import br.com.rodrigofolha.desafio_cadastro_jogadores.model.GrupoCodinome;
import br.com.rodrigofolha.desafio_cadastro_jogadores.repository.CodinomeRepositoryFactory;

@Component
public class CodinomeServiceImpl implements CodinomeService {

    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeServiceImpl(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }

    @Override
    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception {
        var codinomesDisponiveis = listarCodinomesDisponiveis(grupoCodinome, codinomesEmUso);
        if (codinomesDisponiveis.isEmpty())
            throw new GrupoCodinomeIndisponivelException();

        var codinomeSorteado = sortearCodinome(codinomesDisponiveis);
        return codinomeSorteado;
    }

    private List<String> listarCodinomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception {
        List<String> codinomes = buscarCodinomes(grupoCodinome);

        List<String> codinomesDisponiveis = codinomes  
                .stream()
                .filter(codinome -> !codinomesEmUso.contains(codinome))
                .toList();

        return codinomesDisponiveis;
    }

    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws Exception {
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes().getCodinomes();
    }

    private String sortearCodinome(List<String> codinomesDisponiveis) {
        return codinomesDisponiveis.get((int) (Math.random() * codinomesDisponiveis.size()));
    }

}
