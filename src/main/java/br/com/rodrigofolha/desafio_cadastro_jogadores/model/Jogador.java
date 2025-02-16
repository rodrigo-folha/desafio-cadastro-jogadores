package br.com.rodrigofolha.desafio_cadastro_jogadores.model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
public class Jogador {

    @NotBlank
    private String nome;
    @Email
    private String email;
    private String telefone;
    private String Codinome;
    @NotNull
    private GrupoCodinome grupoCodinome;

    public Jogador() {
    }

    public Jogador(String nome, String email, String telefone, String codinome, GrupoCodinome grupoCodinome) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        Codinome = codinome;
        this.grupoCodinome = grupoCodinome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCodinome() {
        return Codinome;
    }

    public void setCodinome(String codinome) {
        Codinome = codinome;
    }

    public GrupoCodinome getGrupoCodinome() {
        return grupoCodinome;
    }

    public void setGrupoCodinome(GrupoCodinome grupoCodinome) {
        this.grupoCodinome = grupoCodinome;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", grupoCodinome=" + grupoCodinome +
                '}';
    }

}
