package br.com.rodrigofolha.desafio_cadastro_jogadores.repository;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.rodrigofolha.desafio_cadastro_jogadores.model.GrupoCodinome;
import br.com.rodrigofolha.desafio_cadastro_jogadores.model.Jogador;

@Repository
public class JogadorRepository {
    private final JdbcClient jdbcClient;

    public JogadorRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Jogador salvar(Jogador jogador) {
        jdbcClient.sql("""
                INSERT INTO JOGADORES (nome, email, telefone, codinome, grupo_codinome)
                VALUES (:nome, :email, :telefone, :codinome, :grupoCodinome)
            """)
            .param("nome", jogador.getNome())
            .param("email", jogador.getEmail())
            .param("telefone", jogador.getTelefone())
            .param("codinome", jogador.getCodinome())
            .param("grupoCodinome", jogador.getGrupoCodinome().name())
            .update();

        return jogador;
    }

    public List<String> listarCodinomesPorGrupo(GrupoCodinome grupoCodinome) {
        return jdbcClient.sql("SELECT distinct(codinome) FROM JOGADORES WHERE grupo_codinome = :grupoCodinome")
            .param("grupoCodinome", grupoCodinome.name())
            .query(String.class)
            .list();
    }

    public List<Jogador> listarJogadores() {
        return jdbcClient.sql("SELECT * FROM JOGADORES ORDER BY LOWER(nome), id")
            .query(Jogador.class)
            .list();
    }
}
