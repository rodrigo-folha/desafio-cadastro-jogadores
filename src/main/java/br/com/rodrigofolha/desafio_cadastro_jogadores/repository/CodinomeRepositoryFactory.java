package br.com.rodrigofolha.desafio_cadastro_jogadores.repository;

import org.springframework.stereotype.Component;

import br.com.rodrigofolha.desafio_cadastro_jogadores.model.GrupoCodinome;

@Component
public class CodinomeRepositoryFactory {
    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository, VingadoresRepository vingadoresRepository) {
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome) {
        return switch(grupoCodinome) {
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case VINGADORES -> vingadoresRepository;
        };
    }

}
